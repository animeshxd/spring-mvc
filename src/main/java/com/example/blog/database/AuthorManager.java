package com.example.blog.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.blog.models.Author;

@Repository("user")
public class AuthorManager implements Manager<Author> {

    private final JdbcTemplate jdbc;

    @Autowired
    public AuthorManager(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void init() {

        String sql = """
                CREATE TABLE IF NOT EXISTS Users(
                    username VARCHAR(32) PRIMARY KEY,
                    name TEXT,
                    email TEXT,
                    password TEXT
                )
                """;
        jdbc.update(sql);
    }

    @Override
    public int create(Author model) {

        return 0;
    }

    @Override
    public int update(Author model) {

        return 0;
    }

    @Override
    public int delete(String key) {

        return 0;
    }

    @Override
    public Author read(String key) {

        return null;
    }

    @Override
    public List<Author> list() {

        return null;
    }

}
