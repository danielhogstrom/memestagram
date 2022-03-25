package com.backend.user;

import com.backend.meme.Memes;
import com.backend.service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/user")
@RestController
public class UserController {
    @Autowired
    MemestagramService service;
    @Autowired
    UserRepository repository;

                         // AWS //
    @PostMapping("/images")
    public String addPicture(@RequestParam MultipartFile imageFile) throws Exception {
        service.saveImage(imageFile);
        service.saveImageAWS(imageFile);
        return "Din bild har skickats";
    }
                        //    //


                        //USER//

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
            session.setAttribute("currentUser", loginForm.getUsername());
            return service.validate(repository.findByUsername(loginForm.getUsername()), loginForm.getPassword());
        }

    }
    //to see a specific users page
    @GetMapping("/{username}")
    User getUser(@PathVariable("username") String username, HttpSession session){
        if(username.equals(session.getAttribute("currentUser"))) {
            return repository.findByUsername(username);
        }
        return null;
    }


    @PostMapping("/removeSession")
    public int logOut(HttpSession session, HttpServletResponse response){
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



}
