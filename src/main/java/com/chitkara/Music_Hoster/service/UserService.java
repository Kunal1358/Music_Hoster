package com.chitkara.Music_Hoster.service;

import com.chitkara.Music_Hoster.model.*;
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

        if (this.UserRepository.existsById(userLogin.getEmailAddress())) {

            return true;
        }
        return false;
    }
}






