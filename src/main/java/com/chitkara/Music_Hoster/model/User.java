package com.chitkara.Music_Hoster.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private long id;

    @Column(name = "firstname" , nullable = false)
    private String firstname;

    @Column(name = "lastname" )
    private String lastname;

    @Id
    @Column(name = "emailAddress" , nullable = false)
    private String emailAddress;

    @Column(name="passowrd" , nullable = false)
    private String password;


    @Column(name = "mobile_number" , nullable = false)
    private String mobileNumber;

    User(){
    }

    public User(String firstname, String lastname, String emailAddress, String password, String mobileNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + id +
                "firstname='" + firstname +
                ", lastname=" + lastname +
                ", emailAddress='" + emailAddress +
                ", password='" + password +
                ", mobileNumber='" + mobileNumber +
                '}';
    }

}
