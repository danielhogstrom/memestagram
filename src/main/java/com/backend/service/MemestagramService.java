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

    public int followedByMe(Long id) {
        List<Long> followByMeList = repository.followList(id);
        return followByMeList.size();

    }

    public List<User> followedByMeByName(Long id) {
        List<Long> followedByMeList = repository.followList(id);
        List<User> followedByMeNames = new ArrayList<>();

        for (int i = 0; i < followedByMeList.size(); i++) {
            followedByMeNames.add(repository.getById((followedByMeList.get(i))));
            System.out.println(followedByMeNames.get(i));

        }

        return followedByMeNames ;
    }
    public int myFollowers(Long id) {
        List<Long> myFollowers = repository.followingList(id);
        return myFollowers.size();

    }

    public List<User> myFollowersByNames(Long id) {
        List<Long> followedByMeList = repository.followingList(id);
        List<User> followedByMeNames = new ArrayList<>();

        for (int i = 0; i < followedByMeList.size(); i++) {
            followedByMeNames.add(repository.getById((followedByMeList.get(i))));
            System.out.println(followedByMeNames.get(i));

        }

        return followedByMeNames ;
    }

}



