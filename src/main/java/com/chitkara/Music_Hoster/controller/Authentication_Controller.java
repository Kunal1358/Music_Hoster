package com.chitkara.Music_Hoster.controller;

import com.chitkara.Music_Hoster.message.ResponseMessage;
import com.chitkara.Music_Hoster.model.*;
import com.chitkara.Music_Hoster.service.UserService;
import com.chitkara.Music_Hoster.service.CustomUserDetailService;

import com.chitkara.Music_Hoster.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;
import com.chitkara.Music_Hoster.model.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.OPTIONS, RequestMethod.GET,
                RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE}, allowedHeaders = "*",
        allowCredentials = "true")

@RestController
public class Authentication_Controller {

    @Autowired
    public UserService UserService;

    @Autowired
    private CustomUserDetailService CustomUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtHelper;

    @RequestMapping(value = "/users/login",method =RequestMethod.POST)
    public Object checkUser(@RequestBody String data) throws Exception {

        System.out.println(data);
        userLogin user = new ObjectMapper().readValue(data, userLogin.class);
        System.out.println(user.toString());
        if(UserService.loginUser(user))
        {
             return generateToken(user);
        }
        System.out.println("Go to Hell!");
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Invalid Credentials"));
    }

    public ResponseEntity<?> generateToken(userLogin user) throws Exception {

        System.out.println(user);

        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(),user.getPassword()));

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("No username found");
        }catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        UserDetails userDetails= this.CustomUserDetailService.loadUserByUsername(user.getEmailAddress());
        String token=this.jwtHelper.generateToken(userDetails);
        System.out.println("JWT " +token);
        //{"token":value}
        return ResponseEntity.ok(new JwtResponse(token));
    }
}