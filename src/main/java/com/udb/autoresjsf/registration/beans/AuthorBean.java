package com.udb.autoresjsf.registration.beans;

import com.udb.autoresjsf.registration.controllers.CreateAuthorController;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.ParseException;

@Named("authorBean")
@SessionScoped
public class AuthorBean implements Serializable {

    private String name;
    private String birthday;
    private String phoneNumber;
    private String genre;

    @Inject
    CreateAuthorController createAuthorController;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void addAuthor() throws ParseException {
        this.createAuthorController.createAuthor(this);
    }

    @Override
    public String toString() {
        return "AuthorBean{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
