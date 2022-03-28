package com.backend.service;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.backend.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;


@Service
public class MemestagramService {


    public boolean validate(User user, String password) {
        return password.equals(user.getPassword());
    }







}



