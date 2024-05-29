package com.emilasheras;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.emilasheras.modules.user.models.User;

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
        // 🧪 debugging
        System.out.println("✅ Hello world!");
        testDB();

        // Intentar persistir un usuario en DB y luego agregarle una password + salt
        User user = testAddUser();
        System.out.println("\n\n\n");
        System.out.println("id: "+user.getId()+" - username: "+user.getUsername());
        System.out.println("\n\n\n");
    
        // todo: implementar la funcion testAddPasswordToUser(user);
        //testAddPasswordToUser(user)
    }

    private static User testAddUser(){
        try{
            // Crear un usuario
            User user = new User();
            user.setUsername("usuario_prueba111");
            user.save();
            return user;
        }catch(Exception e){
            System.out.println("\n\n\nAN ERROR OCCURRED WHILE ADDING A USER TO THE DATABASE");
            e.printStackTrace();
        }
        return null;
    }

    

    private static void testDB() {
        // Create a SessionFactory from hibernate.cfg.xml
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        // Open Session
        Session session = factory.openSession();

        // From here on, i could teorically do some CRUD operations to the database
        System.out.println("\n\n\n✅ Connected to database\n\n\n");

        // Close Session and SessionFactory
        session.close();
        factory.close();
    }

    // Old implementation with just hibernate
    // private static void addTestUser() {
    //     try {
    //         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    //         IUserPasswordDAO userPasswordDAO = new UserPasswordDAOImpl(factory);

    //         String username = "testUser";
    //         String salt = PasswordExpert.generateSalt();
    //         String hashedPassword = PasswordExpert.hashPassword("testPassword", salt);

    //         UserPasswordBackup userPassword = new UserPasswordBackup();
    //         userPassword.setUsername(username);
    //         userPassword.setPasswordHash(hashedPassword);
    //         userPassword.setSalt(salt);

    //         userPasswordDAO.save(userPassword);

    //         System.out.println("User saved successfully!");

    //         factory.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}