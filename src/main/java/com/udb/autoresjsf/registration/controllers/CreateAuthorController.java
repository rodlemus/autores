package com.udb.autoresjsf.registration.controllers;

import com.udb.autoresjsf.database.AuthorModel;
import com.udb.autoresjsf.database.HibernateUtil;
import com.udb.autoresjsf.database.LiteraryGenreModel;
import com.udb.autoresjsf.registration.beans.AuthorBean;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Named
@RequestScoped
public class CreateAuthorController {


    public void createAuthor(AuthorBean authorBean) throws ParseException {
        System.out.println("Creating author"+"\n"+authorBean);
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = dateTimeFormatter.parse(authorBean.getBirthday());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.inTransaction( session -> {
            session.persist(new AuthorModel(authorBean.getName(),birthdate,authorBean.getPhoneNumber()));
        });
        System.out.println("Author created");
    }
}
