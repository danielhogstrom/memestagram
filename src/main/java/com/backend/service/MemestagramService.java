package com.backend.service;

import com.backend.user.User;
import org.springframework.stereotype.Service;

@Service
public class MemestagramService {


    public boolean validate(User user, String password){
        return password.equals(user.getPassword());
    }

}
