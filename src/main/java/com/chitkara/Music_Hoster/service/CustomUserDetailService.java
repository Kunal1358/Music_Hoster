package com.chitkara.Music_Hoster.service;

import com.chitkara.Music_Hoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.chitkara.Music_Hoster.service.UserService;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    public UserService Userservice;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String password=Userservice.getpassword(username);

            return new User(username,password,new ArrayList<>());
    }
}
