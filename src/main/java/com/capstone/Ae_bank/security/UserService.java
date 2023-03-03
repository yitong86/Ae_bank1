package com.capstone.Ae_bank.security;

import com.capstone.Ae_bank.auth.User;
import com.capstone.Ae_bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // getById
    // authenticateUser
    // getCurrentUser
    // getLoggedinUser

//    public User getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User userDetails = (User) authentication.getPrincipal();
//
//        Optional<User> currentUser = userRepository.findById(userDetails.getId());
//
//        if(currentUser.isEmpty()) {
//            return null;
//        }
//
//        return currentUser.get();
//
//    }

}

