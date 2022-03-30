package com.backend.user;

import javax.persistence.*;
@Entity
@Table(name = "user_follow")
public class UserFollow {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User listOwner;
    @OneToOne
    private User friend;

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

}