package com.chitkara.Music_Hoster.model;


import javax.persistence.*;

@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "mobile_number")
    private String mobileNumber;

    UserProfile(){

    }

    public UserProfile(String firstname, String lastname, String emailAddress, String mobileNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    //Getters and Setters
    public Integer getId() {
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

    @Override
    public String toString() {
        return "UserProfile {" +
                "firstname='" + firstname + '\'' +
                ", lastname=" + lastname +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber +
                '}';
    }

}
