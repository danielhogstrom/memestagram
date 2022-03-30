package com.backend.user;

import com.backend.meme.Meme;
import com.backend.service.MemestagramService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
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

    @GetMapping("/all")
    List<User> addUser() {
        return repository.findAll();
    }

    //to validate if the user that tries to log in has user privileges (is a registered user). if true, match password and username, if null return false.
    @PostMapping("/validate")
    boolean loginUser(@RequestBody LoginForm loginForm, HttpSession session) {

        if (repository.findByUsername(loginForm.getUsername()) == null) {
            return false;
        } else {
            session.setAttribute("currentUser", loginForm.getUsername());
            return service.validate(repository.findByUsername(loginForm.getUsername()), loginForm.getPassword());
        }

    }

    //to see a specific users page
    @GetMapping("/{username}")
    User getUser(@PathVariable("username") String username, HttpSession session) {
        if (username.equals(session.getAttribute("currentUser"))) {
            return repository.findByUsername(username);
        }
        return null;
    }


    @PostMapping("/removeSession")
    public int logOut(HttpSession session, HttpServletResponse response) {
        session.invalidate(); //viktigaste
        Cookie cookie = new Cookie("JSESSIONID", "");
        //skriver över JSESSIONID med tomt, så den är förstörd
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        //vill frontend verkligen veta? returna en int möjligtvis. (om något smäller, då får inte frontEnd en int. Då vet vi att det inte blivit något exeption)
        //Sessionen har invaliderats på servern. ÄVen om cookien är kvar har vi loggat ut.
        //det viktiga är att ta bort cookien på servern. Den måste hitta ett nytt sen. Kommer inte få det gamla längre.
        //alltså är vi utloggade.
        //gamla sessionsobjektet är borta..
        return 1;
    }

    @GetMapping("/followcount/{id}")
    public int seeFavorites(@PathVariable Long id) {
        service.getFollower(id);
        service.followers(id);
        return service.followers(id);


    }

    @GetMapping("/followers/{id}")
    public List<User> followers(@PathVariable Long id) {
        List<User> followList = service.getFollower(id);
        System.out.println(followList.get(0));

        return followList;
    }





/*    @PutMapping("/follow/{id}")
    public void follow(@PathVariable Long id, @RequestBody User user){
        User fan = repository.getById(id);
        fan.setUserfollow(user);

        repository.save(fan);
    }*/

    /*Id för att identifiera vem vi ska följa
     * Id för vem jag är.
     * Dessa id's ska kopplas ihop
     * Set*/

}
