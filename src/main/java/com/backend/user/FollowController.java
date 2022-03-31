package com.backend.user;

import com.backend.meme.Meme;
import com.backend.service.MemestagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/api/followers")
@RestController
public class FollowController {
    @Autowired
    MemestagramService service;
    @Autowired
    UserRepository repository;

    @GetMapping("/followingcount/{id}")
    public int seeFavorites(@PathVariable Long id) {
        service.followedByMe(id);
        return service.followedByMe(id); // count on who the user is following, we get the size of the follower list


    }
    @GetMapping("/namesfollowing/{id}")
    public List<User> followers(@PathVariable Long id) {
        List<User> followList = service.followedByMeByName(id);

        return followList; // list of who the user is following
    }
    @GetMapping("/followcount/{id}")
    public int seeFollowings(@PathVariable Long id) {
        service.myFollowers(id);
        return service.myFollowers(id); // count on who the user is following, we get the size of the follower list


    }
    @GetMapping("/namesfollowers/{id}")
    public List<User> myFollowersByName (@PathVariable Long id) {
        List<User> namesOfFollowers = service.myFollowersByNames(id);


        return namesOfFollowers; // list of who the user is following
    }

   @GetMapping("/addfriend/{userId}/{friendId}")
    public void addFriend (@PathVariable Long friendId, @PathVariable Long userId){
        User user = repository.findById(friendId).get();
        User friend = repository.findById(userId).get();
        UserFollow userFollow1 = new UserFollow(friend,user);
       user.getUserfollow().add(userFollow1);
        repository.save(user);
   }




}
