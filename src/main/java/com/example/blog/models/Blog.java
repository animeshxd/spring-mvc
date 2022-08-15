package com.example.blog.models;

public class Blog extends Model{
	
	public Blog(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public String id;
	public String title;
	public String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
