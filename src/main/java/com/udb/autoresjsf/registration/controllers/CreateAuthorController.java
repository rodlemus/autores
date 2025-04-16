package com.udb.autoresjsf.registration.controllers;

import com.udb.autoresjsf.database.AuthorModel;
import com.udb.autoresjsf.database.HibernateUtil;
import com.udb.autoresjsf.registration.beans.AuthorBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.hibernate.SessionFactory;

import java.text.ParseException;

@Named
@RequestScoped
public class CreateAuthorController {


    public void createAuthor(AuthorBean authorBean) throws ParseException {
        System.out.println("Creating author\n" + authorBean);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            // Buscar si ya existe un autor con ese nombre (ignorando mayúsculas/minúsculas)
            Long count = session.createQuery(
                            "SELECT COUNT(a) FROM AuthorModel a WHERE LOWER(a.name) = :name", Long.class)
                    .setParameter("name", authorBean.getName().toLowerCase())
                    .getSingleResult();

            if (count > 0) {
                System.out.println("Ya existe un autor con ese nombre.");
            }

            session.persist(new AuthorModel(
                    authorBean.getName(),
                    authorBean.getBirthday(),
                    authorBean.getPhoneNumber()
            ));

            System.out.println("Author created");
        });
    }

}
