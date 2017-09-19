package pers.thn.spiderGuitars.service;

import java.util.List;


import pers.thn.spiderGuitars.entity.Chords;
import pers.thn.spiderGuitars.entity.DelRepeatClass;

public interface ChordsServiceI {
	
//	public Guitarchords getGuitarchordsById(Integer id);
//	public List<Guitarchords> getAllGuitarChords();
//	
//    public boolean addGc(@Param("title") String title , @Param("image") String image, @Param("other") String other);
//    public boolean updateGc(@Param("title") String title , @Param("image") String image, @Param("other") String other);
//    public boolean delGc(Integer id); 
	
	public Chords getGuitarchordsById(Integer g_id);
	public List<Chords> getAllGuitarChords();
	
    public boolean addGc(String g_title , String g_image,
    					 String g_url , String g_source,
    					 String g_type, String g_kind);
    public boolean updateGc(String g_title ,String g_image,
			  String g_url ,String g_source,
			  String g_type, String g_kind, Integer g_id);
    public boolean delGc(Integer id);
    
    public List<Chords> getGcLimits(Integer index ,Integer count);
    public List<Chords> getGcSearch(String name);
    public int getGcsCounts();
    public int getGcsCountByTitle(String g_title);
    public List<DelRepeatClass> getRepeatData();
    public List<Integer> getIdByTitle(String g_title);
}
