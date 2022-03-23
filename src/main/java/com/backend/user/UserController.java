package com.backend.user;

import com.backend.meme.Memes;
import com.backend.service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
@RestController
public class UserController {
    @Autowired
    MemestagramService service;
    @Autowired
    UserRepository repository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping ("/all")
    List<User> addUser (){
        return repository.findAll();
    }

    //to validate if the user that tries to log in has user privileges (is a registered user). if true, match password and username, if null return false.
    @PostMapping("/validate")
    boolean loginUser(@RequestBody LoginForm loginForm, HttpSession session){

        if (repository.findByUsername(loginForm.getUsername()) == null) {
            return false;
        }else {
            session.setAttribute("username", loginForm.getUsername());
            return service.validate(repository.findByUsername(loginForm.getUsername()), loginForm.getPassword());
        }

    }


    @PostMapping("/images")
    public String addPicture(@RequestParam MultipartFile imageFile) throws Exception {
        service.saveImage(imageFile);
        service.saveImageAWS(imageFile);
        return "Din bild har skickats";
    }
        //to see a specific users page
        @GetMapping("/{username}")
        User getUser (@PathVariable ("username") String username){
            return repository.findByUsername(username);
        }



}
