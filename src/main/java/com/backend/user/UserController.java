package com.backend.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

@CrossOrigin(origins = "http://localhost:3000")
@GetMapping("/")
public String test () {
    return "hello hello";
}


}
