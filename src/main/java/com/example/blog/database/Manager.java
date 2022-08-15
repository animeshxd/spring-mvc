package com.example.blog.database;

import java.util.List;

import com.example.blog.models.Model;

public interface Manager<T extends Model> {
    public void init();
    public int  create(T model);
    public int  update(T model);
    public int  delete(String id);
    public T read(String id);
    public List<T> read();

}
