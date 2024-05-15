package com.emilasheras;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.emilasheras.dao.UserPasswordDAO;
import com.emilasheras.dao.UserPasswordDAOImpl;

/*
 * El proyecto consiste en desarrollar una aplicación de consola en Java que funcione 
 * como un gestor de contraseñas local. La aplicación almacenará contraseñas hasheadas 
 * con un salting único en una base de datos MySQL. Implementará operaciones básicas de 
 * CRUD (Crear, Leer, Actualizar y Borrar) para gestionar las contraseñas. El objetivo 
 * principal es garantizar la seguridad de las contraseñas mediante técnicas de hashing 
 * y salting. Posteriormente, se añadirá una interfaz gráfica de usuario (UI) para mejorar 
 * la interacción con el usuario.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testDB();
        addTestUser();
    }
    private static void testDB() {
        // Create a SessionFactory from hibernate.cfg.xml
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        // Open Session
        Session session = factory.openSession();

        // From here on, i could teorically do some CRUD operations to the database
        System.out.println("✅ Connected to database");

        // Close Session and SessionFactory
        session.close();
        factory.close();
    }
    
    private static void addTestUser() {
        try {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            UserPasswordDAO userPasswordDAO = new UserPasswordDAOImpl(factory);

            String username = "testUser";
            String salt = PasswordUtil.generateSalt();
            String hashedPassword = PasswordUtil.hashPassword("testPassword", salt);

            UserPassword userPassword = new UserPassword();
            userPassword.setUsername(username);
            userPassword.setPasswordHash(hashedPassword);
            userPassword.setSalt(salt);

            userPasswordDAO.save(userPassword);

            System.out.println("User saved successfully!");

            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}