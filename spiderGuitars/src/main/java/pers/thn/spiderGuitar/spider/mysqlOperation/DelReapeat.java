package pers.thn.spiderGuitar.spider.mysqlOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.service.ChordsServiceI;

public class DelReapeat {
	
	static ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
	static ChordsServiceI chordsService = (ChordsServiceI) ac.getBean("chordsService");
	
    public void delReapeat() {
    	Boolean bool = null;
		List<DelRepeatClass> q = chordsService.getRepeatData();
		for (int j = 0; j < q.size(); j++) {
			List<Integer> ss = chordsService.getIdByTitle(q.get(j).getTitle());
				System.out.println(String.valueOf(q.get(j)));
				//bool = chordsService.delGc(Integer.parseInt(String.valueOf(ss.get(1))));
		   }
    }
    
    public static void main(String[] args) {
    	DelReapeat dd = new DelReapeat();
    	System.out.println("去重前数据条数："+ chordsService.getGcsCounts());
    	dd.delReapeat();
    	System.out.println("去重后数据条数："+ chordsService.getGcsCounts());
	}
}
