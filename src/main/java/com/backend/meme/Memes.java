package com.backend.meme;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Memes {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String picurl;
    private String description;
    @Column(name = "memecreatedbyuser")
    private String memeCreatedByUser;





}
