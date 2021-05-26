package com.chitkara.Music_Hoster.controller;

import com.chitkara.Music_Hoster.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chitkara.Music_Hoster.model.*;
import com.chitkara.Music_Hoster.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.OPTIONS, RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE}, allowedHeaders = "*",
        allowCredentials = "true")
@RestController
public class Signup_Controller {

    @Autowired
    public UserService UserService;

    @RequestMapping(value = "/users/registration",method =RequestMethod.POST)
    public ResponseEntity<ResponseMessage> adduser(@RequestBody String data) throws JsonProcessingException {
        System.out.println(data);
        User user = new ObjectMapper().readValue(data, User.class);
        System.out.println(user.toString());
        if(UserService.adduser(user))
        {
            System.out.println("User Added");
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("User Added"));
        }
        System.out.println("Not Added");
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("User Exists"));
    }


}
