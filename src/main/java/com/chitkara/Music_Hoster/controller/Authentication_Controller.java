package com.chitkara.Music_Hoster.controller;

import com.chitkara.Music_Hoster.model.*;
import com.chitkara.Music_Hoster.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.OPTIONS, RequestMethod.GET,
                RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE}, allowedHeaders = "*",
        allowCredentials = "true")

@RestController
public class Authentication_Controller {

    @Autowired
    public UserService UserService;

    @RequestMapping(value = "/users/login",method =RequestMethod.POST)
    public String checkUser(@RequestBody String data) throws JsonProcessingException {

        System.out.println(data);
        userLogin user = new ObjectMapper().readValue(data, userLogin.class);
        System.out.println(user.toString());
        if(UserService.loginUser(user))
        {
            System.out.println("Login Sucessfully");
            return "true";
        }
        System.out.println("Go to Hell!");
        return "false";
    }


}