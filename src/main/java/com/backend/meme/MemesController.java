package com.backend.meme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MemesController {

    @Autowired
    MemesRepository repository;

    @GetMapping("/addmeme")
    List<Memes> addMeme() {
        return repository.findAll();
    }

    @PostMapping("/addmeme")
    Memes postMeme(@RequestBody Memes meme) {
        return repository.save(meme);
    }

}
