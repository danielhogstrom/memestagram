package com.backend.user;

import javax.persistence.*;
@Entity
@Table(name = "user_follow")
public class UserFollow {

    @Id
    @Column
    private Long followId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Long getfollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}