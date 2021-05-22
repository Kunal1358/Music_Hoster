package com.chitkara.Music_Hoster.service;

import com.chitkara.Music_Hoster.model.User;
import com.chitkara.Music_Hoster.model.userLogin;
import com.chitkara.Music_Hoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class UserService {

    @Autowired
    public UserRepository UserRepository;

    public boolean adduser(User user) {

        if (this.UserRepository.existsById(user.getEmailAddress())) {
            return false;
        } else {
            try {
                this.UserRepository.save(user);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

    }


    public boolean loginUser(userLogin userLogin) {

        Optional<User> user1 = this.UserRepository.findById(userLogin.getEmailAddress());
        if (user1.isPresent() ? user1.get().getPassword().equals(userLogin.getPassword()) : false) {
            return true;
        } else {
            return false;
        }
    }
    public String getpassword(String username){
            Optional<User> user =this.UserRepository.findById(username);
            return user.get().getPassword();
        }

}






