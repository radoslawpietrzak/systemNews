package com.systemnews.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by RADEK on 2016-08-30.
 */
@Document
public class Comment {

    @Id
    public String id;
    @NotNull(message = "Brak newsId")
    public String NewsId;
    @NotNull
    @Size(min = 5, max = 2000, message = "Minimuma 5, max 2000")
    public String comment;
    @NotNull
    @Size(min = 2, max = 20, message = "Minimum 2 znaki, max 20 znakow")
    public String author;
    @NotNull
    public String data;

    public Comment(String newsId, String comment, String author, String data) {
        NewsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }

    public Comment() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
