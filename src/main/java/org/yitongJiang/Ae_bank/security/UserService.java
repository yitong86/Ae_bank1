package org.yitongJiang.Ae_bank.security;

import org.yitongJiang.Ae_bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//user sevice
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

