package com.backend.meme;

import com.backend.user.User;
import com.backend.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
@RestController
@RequestMapping("/api/meme")
public class MemesController {

    @Autowired
    MemesRepository repository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    List<Meme> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{user}")
    Set<Meme> findByUser(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        return user.getMyMemes();
    }

    @PostMapping("/{id}/add")
    Meme postMeme(@RequestBody Meme meme, @PathVariable Long id) {
        User user = userRepository.findById(id).get();
        meme.setCreator(user);
        log.info("New meme added to MemeRepository - {}", meme);
        return repository.save(meme);
    }

    @PutMapping("/{id}/{likes}")
        public void editLikes (@PathVariable Long id, @PathVariable Long likes) {
        Meme meme = repository.getById(id);
        meme.setLikes(likes);
        System.out.println("meme liked");
        repository.save(meme);
    }

    @DeleteMapping("/delete/id/{id}")
        public void deleteMeme (@PathVariable Long id){
        repository.deleteById(id);
    }

}
