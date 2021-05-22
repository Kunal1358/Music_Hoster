package com.chitkara.Music_Hoster.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dashboard_Controller {

    @RequestMapping("/welcome")
    public String Welcome(){
        String text="This is a private page";
        text+= " \n You can't acess it";
        return text;
    }

    @RequestMapping("/getusers")
    public String getUsers(){

        return "{\"name\":\"Kunal\"}";
    }
}

