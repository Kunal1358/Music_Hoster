package com.chitkara.Music_Hoster.model;

//Used for jwt response
public class JwtResponse {

    String token;

    JwtResponse(){

    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
