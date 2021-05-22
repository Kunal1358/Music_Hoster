package com.chitkara.Music_Hoster.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Musicid")
    private long Musicid;

    @Column(name = "Name" , nullable = false)
    private String Title;

    @Column(name = "Genre" , nullable = false)
    private String Genre;

    @Column(name = "description" , nullable = false)
    private String description;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    // this is a base64 encoded version of the music
    @Column(columnDefinition = "TEXT")
    private String musicFile;

    @Column(name = "date")
    private Date date;

    //The 'Musics' table is mapped to 'user' table with Many:One mapping
    //One music can have only one user (owner) but one user can have multiple music
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'Musics' table referring the primary
    // key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    Music(){

    }

    public Music(long musicid, String title, String genre, String description, String musicFile, Date date) {
        Musicid = musicid;
        Title = title;
        Genre = genre;
        this.description = description;
        this.musicFile = musicFile;
        this.date = date;
    }

    public Music(long musicid, String title, String genre, String description, String musicFile) {
        Musicid = musicid;
        Title = title;
        Genre = genre;
        this.description = description;
        this.musicFile = musicFile;
    }


    //Getters and Setters

    public long getMusicid() { return Musicid; }

    public void setMusicid(long musicid) { Musicid = musicid; }

    public String getTitle() { return Title; }

    public void setTitle(String title) { Title = title; }

    public String getGenre() { return Genre; }

    public void setGenre(String genre) { Genre = genre; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getMusicFile() { return musicFile; }

    public void setMusicFile(String musicFile) { this.musicFile = musicFile; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Music{" +
                "Musicid=" + Musicid +
                ", Title='" + Title + '\'' +
                ", Genre='" + Genre + '\'' +
                ", description='" + description + '\'' +
                ", musicFile='" + musicFile + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
