package com.backend.meme;

import com.backend.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Memes {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String picurl;
    @Size(min = 2, max = 100)
    private String description;
    @Column(name = "memecreatedbyuser")
    private String memeCreatedByUser;
    private Long likes;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;





}