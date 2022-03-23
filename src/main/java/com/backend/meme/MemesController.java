package com.backend.meme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/meme")
@CrossOrigin(origins = "*")
public class MemesController {

    @Autowired
    MemesRepository repository;

    @GetMapping("/all")
    List<Memes> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{user}")
    List<Memes> findByUser(@PathVariable String user) {
        return repository.findByMemeCreatedByUser(user);
    }

    @PostMapping("/add")
    Memes postMeme(@RequestBody Memes meme) {
        log.info("New meme added to MemeRepository - {}", meme);
        return repository.save(meme);
    }
}
