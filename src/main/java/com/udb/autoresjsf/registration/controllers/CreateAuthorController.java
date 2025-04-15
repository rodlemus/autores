package com.udb.autoresjsf.registration.controllers;

import com.udb.autoresjsf.registration.beans.AuthorBean;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class CreateAuthorController {

    public void createAuthor(AuthorBean authorBean){
        System.out.println("Creating author"+"\n"+authorBean);
    }
}
