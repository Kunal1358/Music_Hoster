package com.chitkara.Music_Hoster.model;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class Music {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String MusicName;

    private String url;

    private long size;

    private String Name;

    private String Description;

    private String Genre;

    @Lob
    private byte[] data;

    public Music() {
    }

    public Music(String musicname, String description, String genre, String name, byte[] data) {
        this.MusicName = musicname;
        this.Name = name;
        this.Description = description;
        this.Genre = genre;
        this.data = data;
    }

    public Music(String musicName,String url,String description,String genre,long size) {
        this.MusicName = musicName;
        this.url = url;
        this.size = size;
        this.Description = description;
        this.Genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getMusicName() {
        return MusicName;
    }

    public void setMusicName(String musicName) {
        MusicName = musicName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}