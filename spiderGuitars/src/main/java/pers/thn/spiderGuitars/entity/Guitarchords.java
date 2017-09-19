package pers.thn.spiderGuitars.entity;

public class Guitarchords {
    private Integer id;
    private String title;
    private String image;
    private String other;
    
	public Guitarchords() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Guitarchords(Integer id, String title, String image, String other) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.other = other;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Guitarchords [id=" + id + ", title=" + title + ", image=" + image + ", other=" + other + "]";
	}
    
    
}
