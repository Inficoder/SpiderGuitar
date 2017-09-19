package pers.thn.spiderGuitars.entity;

public class Chords {
	private Integer g_id;
	private String g_title;
	private String g_image;
	private String g_url;
	private String g_source;
	private String g_type;
	private String g_kind;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getG_image() {
		return g_image;
	}
	public void setG_image(String g_image) {
		this.g_image = g_image;
	}
	public String getG_url() {
		return g_url;
	}
	public void setG_url(String g_url) {
		this.g_url = g_url;
	}
	public String getG_source() {
		return g_source;
	}
	public void setG_source(String g_source) {
		this.g_source = g_source;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public String getG_kind() {
		return g_kind;
	}
	public void setG_kind(String g_kind) {
		this.g_kind = g_kind;
	}
	@Override
	public String toString() {
		return "Chords [g_id=" + g_id + ", g_title=" + g_title + ", g_image=" + g_image + ", g_url=" + g_url
				+ ", g_source=" + g_source + ", g_type=" + g_type + ", g_kind=" + g_kind + "]";
	}
	
	
}
