package com.udb.autoresjsf.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            // Propiedades equivalentes al persistence.xml
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/autores-db");
            settings.put(Environment.USER, "admin");
            settings.put(Environment.PASS, "asdasd");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.FORMAT_SQL, "true");
            // Opcional para resaltar SQL (si usás Hibernate 6+)
            settings.put("hibernate.highlight_sql", "true");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(LiteraryGenreModel.class);
            configuration.addAnnotatedClass(AuthorModel.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return  sessionFactory;
        }
        return sessionFactory;
    }
}
