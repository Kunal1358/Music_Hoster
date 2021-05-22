package com.chitkara.Music_Hoster.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Call a method from repo which will give data of the user if Using DB 19:06

        //This method will return User when this Method is called
        if(username.equals("Kunal")){
            return new User("Kunal","Kunal",new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User Not Found!!!");
        }
    }
}
