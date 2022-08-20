package com.example.models;

public class Blog extends Model{
	
	public Blog(String id, String title, String content, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public String id;
	public String title;
	public String content;
	public String author = "guest";
	
	public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
	
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
