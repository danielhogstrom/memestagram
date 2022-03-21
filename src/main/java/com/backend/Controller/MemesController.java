package com.backend.Controller;

import com.backend.Entity.Memes;
import com.backend.Repository.MemeRepository;
import com.backend.Service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class MemesController {

    @Autowired
    MemeRepository repository;
    @Autowired
    MemestagramService service;

    @GetMapping("/addmeme")
    String addMeme() {
        return "add a meme";

    }

    @PostMapping("/addmeme")
    Memes postMeme(@RequestBody Memes meme) {
        return repository.save(meme);


    }

}
