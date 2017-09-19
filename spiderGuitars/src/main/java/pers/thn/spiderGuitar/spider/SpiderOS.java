package pers.thn.spiderGuitar.spider;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.thn.spiderGuitars.service.ChordsServiceI;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class SpiderOS implements PageProcessor {
	private Site site = Site.me().setRetrySleepTime(100).setRetryTimes(1);
	private static int count;
	private String g_title;
	private String g_image;
	private String g_url;
	private String g_source;
	private String g_type;
	private String g_kind;
	private Html html;
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
	ChordsServiceI chordsService  = (ChordsServiceI) ac.getBean("chordsService");
	
	public Site getSite() {
		return site;
	}

	public synchronized void process(Page page) {
		if(!page.getUrl().regex("http://www.17jita.com/tab/img/\\d{1,10}.html").match()) {
			
			List<String> urlList = page.getHtml().xpath("//*[@id=\"ct\"]/div[1]/div[2]/div[3]/dl/dt/a/@href").all();
			for (int i = 0; i < urlList.size(); i++) {
				urlList.set(i, "http://www.17jita.com/"+urlList.get(i));
				page.addTargetRequest(urlList.get(i));
			}
		}else
		{	
				html = page.getHtml();
				g_title = html.xpath("//*[@id=\"wp\"]/div[2]/div[1]/h1/text()").toString();
				g_image = html.xpath("//*[@id=\"article_contents\"]/a/img/@src").toString();
				g_url = page.getUrl().toString();
				g_source = "17吉他谱";
				if(g_image == null) {
					g_image = "/spiderGuitars/image/timenoimage.jpg";
				}
				chordsService.addGc(g_title, g_image, g_url, g_source, g_type, g_kind);
				count++;  
//			System.out.println("爬取的结果："+page.getHtml().xpath("//*[@id=\"wp\"]/div[2]/div[1]/h1/text()").all());
//			System.out.println("图片："+page.getHtml().xpath("//*[@id=\"article_contents\"]/a/img/@src").all());
//			count++;
		}
		
	}
	public static void startPgae(int currentPage) {
		Spider.create(new SpiderOS()).addUrl("http://www.17jita.com/tab/img/index.php?page="+currentPage).thread(5).run();
	}
	
	public static void main(String[] args) {
		int pageCount = 1;
		long start , end;
		System.out.println("开始爬取..");
		start = System.currentTimeMillis();
		for(int i = 1;i <= pageCount;i++) {
			startPgae(i);
		}

		end = System.currentTimeMillis();
		System.out.println("爬取了 " + count +" 条记录，"+"花费了 " +(end - start)/1000 + " 秒的时间..");
	}
}
