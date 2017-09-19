package pers.thn.spiderGuitar.spider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.thn.spiderGuitars.service.ChordsServiceI;
import pers.thn.spiderGuitars.service.GuitarServiceI;
import pers.thn.spiderGuitars.service.GuitarServiceImpl;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class SpiderDw implements PageProcessor{
	
	private Site site = Site.me().setRetrySleepTime(1000).setRetryTimes(1);
	private static int count;
	private Html html;
	private String g_title;
	private String g_image;
	private String g_url;
	private String g_source;
	private String g_type;
	private String g_kind;
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
	ChordsServiceI chordsService  = (ChordsServiceI) ac.getBean("chordsService");
	public Site getSite() {
		return site;
	}

	public synchronized void process(Page page) {
		if(!page.getUrl().regex("http://www.daweijita.com/\\d{1,10}.html").match()) {
			page.addTargetRequests(
					page.getHtml().xpath("//*[@id=\"main-content\"]/div[2]/div[2]/section/div/div/ul/li/h2/a/@href").all()
					);
		}else
		{
				html = page.getHtml();
				g_title = html.regex("<h1 class=\"post-title\" itemprop=\"headline\">(.*?)</h1>").toString();
				g_image = html.regex("<img data-tag=\"bdimg\" data-original=\"(.*?)\"").toString();
				g_url = page.getUrl().toString();
				g_source = "大伟吉他教室";
				if(g_image == null) {
					g_image = "/spiderGuitars/image/timenoimage.jpg";
				}
				chordsService.addGc(g_title, g_image, g_url, g_source, g_type, g_kind);
				count++;  
		}
	}
	
	public static void startPgae(int currentPage) {
		Spider.create(new SpiderDw()).addUrl(
				"http://www.daweijita.com/video_lesson/page/"+currentPage).thread(5).run();
	}

	public static void main(String[] args) {
		long start,end;
		int pageCount = 1;
		System.out.println("开始爬取...");
		start = System.currentTimeMillis();
		for(int i = 1;i <=pageCount;i++) {
			startPgae(i);
		}
		end = System.currentTimeMillis();
		System.out.println("爬取了 " + count +" 条记录，"+"花费了 " +(end - start)/1000 + " 秒的时间..");
	}
}
