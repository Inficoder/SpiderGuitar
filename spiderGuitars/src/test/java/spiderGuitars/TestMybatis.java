package spiderGuitars;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;

import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.entity.Guitarchords;
import pers.thn.spiderGuitars.service.ChordsServiceI;
import pers.thn.spiderGuitars.service.GuitarServiceI;

public class TestMybatis {

	@Test
	public void test01()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
		GuitarServiceI guitarService = (GuitarServiceI) ac.getBean("guitarService");
//		Guitarchords g = guitarService.getGuiatchordsById(1);
//		System.out.println(g);
		
//		.addGc("2", "2", "2");
//		guitarService.updateGc("3", "3", "3",2);
//		PageHelper.startPage(1, 20); // 核心分页代码  
//        List<Guitarchords> cls =  guitarService.getGcLimits(7, 6);
//        for (Guitarchords s : cls) {  
//            System.out.println(s);  
//        }  
//		int count = guitarService.getGcsCountByTitle("中国之星 齐秦《一江水》吉他教学");
//		System.out.println(count);
		Boolean bool = null;
		List<DelRepeatClass> q = guitarService.getRepeatData();
		for (int j = 0; j < q.size(); j++) {
			List<Integer> ss = guitarService.getIdByTitle(q.get(j).getTitle());
				System.out.println(String.valueOf(ss.get(1)));
				bool = guitarService.delGc(Integer.parseInt(String.valueOf(ss.get(1))));
		   }
		}
	@Test
	public void test02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
		ChordsServiceI chordsService  = (ChordsServiceI) ac.getBean("chordsService");
		
		//chordsService.getAllGuitarChords();
		//chordsService.addGc("2", "2", "2", "2", "2", "2");
		chordsService.getGcSearch("放心");
		
	}
	}


