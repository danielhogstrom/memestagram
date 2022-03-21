package com.backend.Controller;

import com.backend.Entity.Memes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemesController {
@GetMapping ("/addmeme")
String addMeme (){
    return "add a meme";

}
@PostMapping ("/addmeme")
String postMeme (@RequestParam String picURL, RequestParam description) {



}

}
