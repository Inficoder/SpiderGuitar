package pers.thn.spiderGuitars.service;

import java.util.List;

import pers.thn.spiderGuitars.entity.Chords;
import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.entity.Guitarchords;

public interface GuitarServiceI {
	
//	public Guitarchords getGuitarchordsById(Integer id);
//	public List<Guitarchords> getAllGuitarChords();
//	
//    public boolean addGc(@Param("title") String title , @Param("image") String image, @Param("other") String other);
//    public boolean updateGc(@Param("title") String title , @Param("image") String image, @Param("other") String other);
//    public boolean delGc(Integer id); 
	
	public Guitarchords getGuiatchordsById(Integer id);
	public List<Guitarchords> getAllGuitarChords();
    public boolean addGc(String title ,String image, String other);
    public boolean updateGc(String title ,String image,  String other,Integer id);
    public boolean delGc(Integer id);
    public List<Guitarchords> getGcLimits(Integer index , Integer count);
    public List<Guitarchords> getGcSearch(String name);
    public int getGcsCounts();
    public int getGcsCountByTitle(String title);
    public List<DelRepeatClass> getRepeatData();
    public List<Integer> getIdByTitle(String title);
}
