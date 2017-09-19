package pers.thn.spiderGuitars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.thn.spiderGuitars.entity.Chords;
import pers.thn.spiderGuitars.service.ChordsServiceI;

@Controller
@RequestMapping("guitarController")
public class GuitarController {
	
	@Autowired
	private ChordsServiceI chordsService;
	 //查询所有
	@RequestMapping(value="/showAllGcs",method=RequestMethod.GET)  
	public String showAllGc(HttpServletRequest request) {
		List<Chords> Chords = chordsService.getAllGuitarChords();
		request.setAttribute("Chords", Chords);
		System.out.println(Chords);
		return "guitar/showAllGcs";
	}
	//通过ID查询
	@RequestMapping(value="/showGuitarById/{id}",method=RequestMethod.GET)   
	public String showgcById(@PathVariable("id") Integer id , HttpServletRequest request) {
		Chords gc = chordsService.getGuitarchordsById(id);
		request.setAttribute("gc", gc);
		System.out.println(gc);
		return "guitar/guitarShowOne";
	}
	//分页
	@RequestMapping(value="/showDiv/page/{pageNum}",method=RequestMethod.GET)  
	public String showDiv(@PathVariable("pageNum") Integer pageNum , HttpServletRequest request) {
		if(pageNum == null) {
			pageNum =1 ;
		};
		int everyPagecounts = 18;
		int index = (pageNum-1)*everyPagecounts;
		int counts = chordsService.getGcsCounts();
		int pageAllCount = (counts%everyPagecounts)==0?counts/everyPagecounts:counts/everyPagecounts+1;
		List<Chords> Chords = chordsService.getGcLimits(index, everyPagecounts);
		request.setAttribute("Chords", Chords);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageAllCount", pageAllCount);
		return "guitar/showDivPages";
	}
	//模糊查询
	@RequestMapping(value="/showSearch/{key}",method=RequestMethod.GET)
	public String showSearch(@PathVariable("key") String key,HttpServletRequest request) {
		List<Chords> search = chordsService.getGcSearch(key);
		request.setAttribute("search", search);
		request.setAttribute("key", key);
		return "index";
	}
}
