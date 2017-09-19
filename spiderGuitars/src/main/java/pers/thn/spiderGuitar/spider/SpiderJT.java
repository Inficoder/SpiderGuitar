package pers.thn.spiderGuitar.spider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.thn.spiderGuitars.service.ChordsServiceI;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class SpiderJT implements PageProcessor {
	private Site site = Site.me().setRetrySleepTime(100).setRetryTimes(1);
	static List<String> list = new ArrayList();
	static List<String> list2 = new ArrayList();
	private static int count;
	private String g_title;
	private String g_image = "/spiderGuitars/image/timenoimage.jpg";
	private String g_url;
	private String g_source = "吉他吧";
	private String g_type;
	private String g_kind;
	private Html html;
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
	ChordsServiceI chordsService  = (ChordsServiceI) ac.getBean("chordsService");
	
	public Site getSite() {
		return site;
	}

	public synchronized void process(Page page) {
		list = page.getHtml().xpath("/html/body/div[2]/div[2]/ul/li/h3/a/@href").all();
		list2= page.getHtml().xpath("/html/body/div[2]/div[2]/ul/li/h3/a/text()").all();
		
		
		for (int i = 0; i < list.size(); i++) {
			chordsService.addGc(list2.get(i), g_image, list.get(i), g_source, g_type, g_kind);
		}
		
	}
	public static void startPgae(int currentPage) {
		Spider.create(new SpiderJT()).addUrl("http://www.jitaba.cn/pic/list_48_"+currentPage+".html").thread(5).run();
	}
	
	public static void main(String[] args) {
		int pageCount = 1;
		long start , end;
		System.out.println("开始爬取..");
		start = System.currentTimeMillis();
		for(int i = 1;i <= pageCount;i++) {
			startPgae(i);
		}
//		Spider.create(new SpiderJT()).addUrl("http://www.jitaba.cn/pic/list_48_1.html").thread(5).run();
		end = System.currentTimeMillis();
		count = list.size();
		System.out.println("爬取了 " + count +" 条记录，"+"花费了 " +(end - start)/1000 + " 秒的时间..");
	}
}
