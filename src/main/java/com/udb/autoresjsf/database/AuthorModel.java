package com.udb.autoresjsf.database;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AuthorModel {

    @Id @GeneratedValue
    private long id;

    private String name;

    private Date birthDate;

    private String phoneNumber;

    public AuthorModel(String name, Date birthDate, String phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = true)
    LiteraryGenreModel genreModel;


}
