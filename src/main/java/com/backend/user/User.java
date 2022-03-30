package com.backend.user;


import com.backend.meme.Meme;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "usertable")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3, max=30)
    private String username;
    @Size(min=6, max=30)
    private String password;
    @Email
    private String email;
    private String bio;
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private Set<Meme> myMemes;
    @ManyToOne
    @JoinTable(name = "user_follow", joinColumns = @JoinColumn(name = "userId") , inverseJoinColumns = @JoinColumn(name = "followId") )
    private Set<UserFollow> userfollow;


    public User() {
    }

    public User(Long id, String username, String password, String email, String bio, Set<Meme> myMemes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.bio = bio;
        this.myMemes = myMemes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Meme> getMyMemes() {
        return myMemes;
    }

    public void setMyMemes(Set<Meme> myMemes) {
        this.myMemes = myMemes;
    }

    public Set<UserFollow> getUserfollow() {
        return userfollow;
    }

    public void setUserfollow(Set<UserFollow> userfollow) {
        this.userfollow = userfollow;
    }
}