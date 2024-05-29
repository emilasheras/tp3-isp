package com.emilasheras.components.util;

import org.hibernate.cfg.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Static Initializer: Utilizamos un inicializador estático para crear una única instancia
 * de EntityManagerFactory al inicio de la aplicación. Esto asegura que la fábrica de entidades
 * se crea una sola vez y se reutiliza.
 * 
 * getEntityManager(): Este método proporciona una nueva instancia de EntityManager para cada llamada.
 * Es el responsable de proporcionar el EntityManager a las entidades cuando necesitan realizar
 * operaciones de persistencia.
 * 
 * closeEntityManager(EntityManager em): Este método cierra un EntityManager específico si está abierto.
 * Es útil para asegurarse de que los recursos se liberan correctamente después de su uso. 
 * 
 * closeEntityManagerFactory(): Este método cierra el EntityManagerFactory cuando ya no se necesita, 
 * generalmente al finalizar la aplicación.
 */
public class EntityManagerUtil {

    private static final EntityManagerFactory entityManagerFactory;
    // private static String PERSISTENCE_UNIT_NAME = "app-mysql-persistence-01"; // no voy a usar persistence.xml

    static { // <- que onda con esto , manso, no tenemos de esos en php 5 creo jaj
        try {
            // entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityManagerFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
