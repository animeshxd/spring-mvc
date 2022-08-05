package com.example.blog.database;

import java.util.List;

import com.example.blog.models.Blog;

public interface Manager {
    public void init();
    public int  put(Blog blog);
    public int  update(Blog blog);
    public int  remove(String id);
    public Blog get(String id);
    public List<Blog> get();

}
