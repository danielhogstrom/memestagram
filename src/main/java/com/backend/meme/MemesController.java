package com.backend.meme;

import com.backend.user.User;
import com.backend.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/meme")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
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
        Meme persistedMeme = repository.save(meme);
        persistedMeme.setCreator(user);
        log.info("New meme added to MemeRepository - {} by user {}", meme, user);
        return repository.save(persistedMeme);
    }

    @GetMapping("/addLike/{id}")
        public Long addLike (@PathVariable Long id) {
        Meme meme = repository.findById(id).get();
        meme.setLikes(meme.getLikes() +1);
        repository.save(meme);
        log.info("Added like to meme id {}", meme.getId());
        return meme.getLikes();
    }


    @GetMapping("/removeLike/{id}")
    public Long removeLike (@PathVariable Long id) {
        Meme meme = repository.findById(id).get();
        meme.setLikes(meme.getLikes() -1);
        repository.save(meme);
        log.info("Removed like to meme id {}", meme.getId());
        return meme.getLikes();
    }
    @GetMapping("/getNumberOfLikes/{id}")
    public Long getNumberOfLikes(@PathVariable Long id){
        return repository.findById(id).get().getLikes();
    }
    @DeleteMapping("/delete/id/{id}")
        public void deleteMeme (@PathVariable Long id){
        repository.deleteById(id);
    }

}
