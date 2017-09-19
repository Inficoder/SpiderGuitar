package pers.thn.spiderGuitars.entity;

public class DelRepeatClass {
    private String count;
    private String g_title;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTitle() {
		return g_title;
	}
	public void setTitle(String title) {
		this.g_title = title;
	}
	@Override
	public String toString() {
		return "DelRepeatClass [count=" + count + ", g_title=" + g_title + "]";
	}
    
    
}
