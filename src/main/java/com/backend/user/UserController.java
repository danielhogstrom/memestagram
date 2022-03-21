package com.backend.user;

import com.backend.Entity.User;
import com.backend.Repository.UserRepository;
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
/*

    @PostMapping("/adduser")
    User addUserObj(@RequestBody User user){
        System.out.println("Called");

        return repository.addUser(service.createUser(user));
    }

 */
}
