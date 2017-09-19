package pers.thn.spiderGuitars.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.thn.spiderGuitars.entity.Chords;
import pers.thn.spiderGuitars.entity.DelRepeatClass;


public interface ChordsMapper {
	
//	     g_id
//		 g_title
//		 g_image
//		 g_url;
//		 g_source
//		 g_type
//		 g_kind
	public Chords getGuitarchordsById(Integer g_id);
	public List<Chords> getAllGuitarChords();
	
    public boolean addGc(@Param("g_title") String g_title , @Param("g_image") String g_image,
    					 @Param("g_url") String g_url , @Param("g_source") String g_source,
    					 @Param("g_type")String g_type,@Param("g_kind") String g_kind);
    public boolean updateGc(@Param("g_title") String g_title , @Param("g_image") String g_image,
			 @Param("g_url") String g_url , @Param("g_source") String g_source,
			 @Param("g_type")String g_type,@Param("g_kind") String g_kind,@Param("g_id") Integer g_id);
    public boolean delGc(Integer id);
    
    public List<Chords> getGcLimits(@Param("index") Integer index , @Param("count")Integer count);
    public List<Chords> getGcSearch(String name);
    public int getGcsCounts();
    public int getGcsCountByTitle(String g_title);
    public List<DelRepeatClass> getRepeatData();
    public List<Integer> getIdByTitle(String g_title);
}
