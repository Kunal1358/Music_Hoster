package com.chitkara.Music_Hoster.model;

public class userLogin {


    private String emailAddress;
    private String password;

    userLogin(){

    }

    public userLogin(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userLogin {" +
                ", emailAddress='" + emailAddress +
                ", password='" + password +
                '}';
    }
}
