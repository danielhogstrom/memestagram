package com.backend.user;


import com.backend.meme.Memes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usertable")
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Memes> myMemes;

}