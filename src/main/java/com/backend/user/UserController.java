package com.backend.user;

import com.backend.meme.Memes;
import com.backend.service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    MemestagramService service;
    @Autowired
    UserRepository repository;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping ("/adduser")
    List<User> addUser (){
        return repository.findAll();
    }

    //to validate if user that tries to log in has user privileges (is a registered user)
    @PostMapping("/validate")
    boolean loginUser(@RequestBody LoginForm loginForm){
        if (repository.findByUsername(loginForm.getUsername()) == null)
            return false;
        return service.validate(repository.findByUsername(loginForm.getUsername()), loginForm.getPassword());
    }
    //to see a specific users page
    @GetMapping("/{username}")
    User getUser(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }
}
