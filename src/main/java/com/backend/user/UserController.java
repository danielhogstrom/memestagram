package com.backend.user;

import com.backend.Service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    MemestagramService service;
    @Autowired
    UserRepository repository;


    @GetMapping("/")
    public String test () {
    return "hello hello";
}


    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return repository.save(user);

    }
}
