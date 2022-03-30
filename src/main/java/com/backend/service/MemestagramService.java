package com.backend.service;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.backend.user.User;
import com.backend.user.UserController;
import com.backend.user.UserFollow;
import com.backend.user.UserRepository;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;


@Service
public class MemestagramService {
    @Autowired
    UserRepository repository;


    public boolean validate(User user, String password) {
        return password.equals(user.getPassword());
    }

    public int followers(Long id) {
        List<Long> followList = repository.followList(id);
        return followList.size();

    }

    public List<User> getFollower(Long id) {
        List<Long> followers = repository.followList(id);
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < followers.size(); i++) {
            userList.add(repository.getById((followers.get(i))));
            System.out.println(userList.get(i));

        }
        System.out.println(userList.get(0));
        return userList ;
    }


}



