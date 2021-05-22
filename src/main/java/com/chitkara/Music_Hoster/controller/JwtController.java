package com.chitkara.Music_Hoster.controller;

import com.chitkara.Music_Hoster.service.CustomUserDetailService;
import com.chitkara.Music_Hoster.model.JwtRequest;
import com.chitkara.Music_Hoster.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chitkara.Music_Hoster.security.JwtUtil;


//Conrtoller to generate token

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService CustomUserDetailService;

    @Autowired
    private JwtUtil jwtHelper;

    //Give the allowed url here
    //Check Security congig
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToekn(@RequestBody JwtRequest JwtRequest) throws Exception {

        System.out.println(JwtRequest);

        try{

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(JwtRequest.getUsername(),JwtRequest.getPassword()));

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        /*
        Request username and password
        Authenticated if error try catch will handel that
        if true Jwt token generated and returned.
         */


        UserDetails userDetails= this.CustomUserDetailService.loadUserByUsername(JwtRequest.getUsername());

        String token=this.jwtHelper.generateToken(userDetails);

        System.out.println("JWT " +token);

        //{"token":value}

        return ResponseEntity.ok(new JwtResponse(token));

    }

}

