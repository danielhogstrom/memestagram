package com.backend.meme;

import com.backend.user.User;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Meme {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String picurl;
    @Size(min = 2, max = 100)
    private String description;
    private Long likes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User creator;

    public Meme(Long id, String picurl, String description, Long likes, User creator) {
        this.id = id;
        this.picurl = picurl;
        this.description = description;
        this.likes = likes;
        this.creator = creator;
    }

    public Meme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}