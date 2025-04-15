package com.udb.autoresjsf.registration;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@ManagedBean
@ApplicationScoped
public class AuthorBean implements Serializable {

    private String name;
    private String birthday;
    private String phoneNumber;
    private String genre;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addAuthor(){
        System.out.println("Author Added");
    }
}
