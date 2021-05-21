package com.chitkara.Music_Hoster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.upgrad.backend.ETE.exception.ResourceNotFoundException;
import com.chitkara.Music_Hoster.model.*;
import com.chitkara.Music_Hoster.repository.*;
import com.chitkara.Music_Hoster.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class Signup_Controller {

    @Autowired
    public UserService UserService;

    @RequestMapping(value = "/addUser",method =RequestMethod.POST)
    public String adduser(@RequestBody String data) throws JsonProcessingException {
        System.out.println(data);
        User user = new ObjectMapper().readValue(data, User.class);
        System.out.println(user.toString());
        if(UserService.adduser(user))
        {
            System.out.println("User Added");
            return "true";
        }
        System.out.println("Not Added");
        return "false";
    }







}
