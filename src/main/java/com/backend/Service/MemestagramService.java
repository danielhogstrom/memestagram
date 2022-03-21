package com.backend.Service;

import com.backend.Entity.User;
import com.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemestagramService {
    @Autowired
    UserRepository userRepository;


}
