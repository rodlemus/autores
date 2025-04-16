package com.udb.autoresjsf.database;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LiteraryGenreModel {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public LiteraryGenreModel(String name) {
        this.name = name;
    }
}
