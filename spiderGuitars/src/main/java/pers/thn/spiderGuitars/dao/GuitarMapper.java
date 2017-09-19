package pers.thn.spiderGuitars.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.entity.Guitarchords;

public interface GuitarMapper {
	public Guitarchords getGuitarchordsById(Integer id);
	public List<Guitarchords> getAllGuitarChords();
	
    public boolean addGc(@Param("title") String title , @Param("image") String image, @Param("other") String other);
    public boolean updateGc(@Param("title") String title , @Param("image") String image, @Param("other") String other,@Param("id") Integer id);
    public boolean delGc(Integer id);
    
    public List<Guitarchords> getGcLimits(@Param("index") Integer index , @Param("count")Integer count);
    public List<Guitarchords> getGcSearch(String name);
    public int getGcsCounts();
    public int getGcsCountByTitle(String title);
    public List<DelRepeatClass> getRepeatData();
    public List<Integer> getIdByTitle(String title);
}
