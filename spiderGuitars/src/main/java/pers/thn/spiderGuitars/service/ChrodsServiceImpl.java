package pers.thn.spiderGuitars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.thn.spiderGuitars.dao.ChordsMapper;
import pers.thn.spiderGuitars.dao.GuitarMapper;
import pers.thn.spiderGuitars.entity.Chords;
import pers.thn.spiderGuitars.entity.DelRepeatClass;
import pers.thn.spiderGuitars.entity.Guitarchords;

@Service("chordsService")
public class ChrodsServiceImpl implements ChordsServiceI {
	
	@Autowired
	private ChordsMapper chordsMapper;

	public Chords getGuitarchordsById(Integer g_id) {
		return chordsMapper.getGuitarchordsById(g_id);
	}

	public List<Chords> getAllGuitarChords() {
		return chordsMapper.getAllGuitarChords();
	}

	public boolean addGc(String g_title, String g_image, String g_url, String g_source, String g_type, String g_kind) {
		return chordsMapper.addGc(g_title, g_image, g_url, g_source, g_type, g_kind);
	}

	public boolean updateGc(String g_title, String g_image, String g_url, String g_source, String g_type, String g_kind,
			Integer g_id) {
		return chordsMapper.updateGc(g_title, g_image, g_url, g_source, g_type, g_kind, g_id);
	}

	public boolean delGc(Integer id) {
		return chordsMapper.delGc(id);
	}

	public List<Chords> getGcLimits(Integer index, Integer count) {
		return chordsMapper.getGcLimits(index, count);
	}

	public List<Chords> getGcSearch(String name) {
		return chordsMapper.getGcSearch("%"+name+"%");
	}

	public int getGcsCounts() {
		return chordsMapper.getGcsCounts();
	}

	public int getGcsCountByTitle(String g_title) {
		return chordsMapper.getGcsCountByTitle(g_title);
	}

	public List<DelRepeatClass> getRepeatData() {
		return chordsMapper.getRepeatData();
	}
	
	public List<Integer> getIdByTitle(String g_title) {
		return chordsMapper.getIdByTitle(g_title);
	}

	
	
}
