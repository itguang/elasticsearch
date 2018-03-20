package com.itguang.elasticsearch.entity;

import io.searchbox.annotations.JestId;

/**
 * @author itguang
 * @create 2018-03-20 12:29
 **/


public class Article {


    @JestId
    private String id;

    private String author;

    private String title;

    public Article() {
    }

    public Article(String id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Article(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
