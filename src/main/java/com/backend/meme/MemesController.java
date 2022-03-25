package com.backend.meme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/meme")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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

    @PutMapping("/id/{id}/likes/{likes}")
        public void editLikes (@PathVariable Long id, @PathVariable Long likes) {
        Memes meme = repository.getById(id);
        meme.setLikes(likes);
        repository.save(meme);
    }

    @DeleteMapping("/delete/id/{id}")
        public void deleteMeme (@PathVariable Long id){
        repository.deleteById(id);
    }

}
