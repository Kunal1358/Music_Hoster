package com.chitkara.Music_Hoster.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.OPTIONS, RequestMethod.GET,
                RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE}, allowedHeaders = "*",
        allowCredentials = "true")
@RestController
public class Music {


}
