package com.backend.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name = "user_follow")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class UserFollow {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User listOwner;
    @OneToOne
    private User friend;

    public UserFollow( User listOwner, User friend) {

        this.listOwner = listOwner;
        this.friend = friend;
    }

    public UserFollow() {
    }

    public Long getfollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public User getUser() {
        return friend;
    }

    public void setUser(User user) {
        this.friend = user;
    }

    public User getListOwner() {
        return listOwner;
    }

    public void setListOwner(User listOwner) {
        this.listOwner = listOwner;
    }
}