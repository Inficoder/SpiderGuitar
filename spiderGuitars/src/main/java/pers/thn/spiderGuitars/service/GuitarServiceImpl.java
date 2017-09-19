package pers.thn.spiderGuitars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pers.thn.spiderGuitars.dao.GuitarMapper;
import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.entity.Guitarchords;

@Service("guitarService")
public class GuitarServiceImpl implements GuitarServiceI {
	
	@Autowired
	private GuitarMapper guitarMapper;

	public Guitarchords getGuiatchordsById(Integer id) {
		return guitarMapper.getGuitarchordsById(id);
	}

	public List<Guitarchords> getAllGuitarChords() {
		return guitarMapper.getAllGuitarChords();
	}

	public boolean addGc(String title, String image, String other) {
		return guitarMapper.addGc(title, image, other);
	}

	public boolean updateGc(String title, String image, String other,Integer id) {
		return guitarMapper.updateGc(title, image, other,id);
	}

	public boolean delGc(Integer id) {
		return guitarMapper.delGc(id);
	}

	public List<Guitarchords> getGcLimits(Integer index, Integer count) {
		return guitarMapper.getGcLimits(index, count);
	}

	public List<Guitarchords> getGcSearch(String name) {
		return guitarMapper.getGcSearch("%"+name+"%");
	}

	public int getGcsCounts() {
		return guitarMapper.getGcsCounts();
	}

	public int getGcsCountByTitle(String title) {  //去重查询
		return guitarMapper.getGcsCountByTitle(title);
	}
	
	public List<DelRepeatClass> getRepeatData() {
		return guitarMapper.getRepeatData();
	}
	
	 public List<Integer> getIdByTitle(String title){
		 return guitarMapper.getIdByTitle(title);
	 }
	
}
