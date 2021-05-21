package com.chitkara.Music_Hoster.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;

    @Column(name = "emailAddress " , nullable = false)
    private String emailAddress;

    @Column(name="passowrd" , nullable = false)
    private String password;

    //The 'users' table is mapped to 'user_profile' table with One:One mapping
    //cascade = CascadeType.ALL specifies that if a record in 'user_profile' table is deleted or updated, then
    // all the records in 'users' table associated to that particular record in 'user_profile' table will
    // be deleted or updated  first and then the record in the 'user_profile' table will be deleted or updated
    //FetchType is EAGER
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'users' table referring the primary key in 'user_profile' table will be 'profile_id'
    @JoinColumn(name = "user_id")
    private UserProfile profile;


    User(){
    }

    public User(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "User {" +
                "emailAddress='" + emailAddress + '\'' +
                ", password=" + password +
                '}';
    }

}
