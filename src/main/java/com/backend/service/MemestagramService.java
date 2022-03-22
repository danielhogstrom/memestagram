package com.backend.service;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.backend.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    public void saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/photos/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);

    }

    public void saveImageAWS(MultipartFile imageFile) throws Exception {
        String bucketName = "memestagram";
        String fileName = "/photos/" + imageFile.getOriginalFilename();
        System.out.format("Uploading %s to S3 bucket %s...\n", fileName, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_NORTH_1).build();
        try {
            s3.putObject(bucketName, fileName, new File(fileName));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }



}
