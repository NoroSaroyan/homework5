package ru.gb;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class DataBaseConnection {
    private EntityManager entityManager;

    public DataBaseConnection() {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        this.entityManager = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}