package com.emilasheras.modules.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.emilasheras.modules.user.models.UserPassword;

import java.util.List;

public class UserPasswordDAOImpl implements IUserPasswordDAO {
    private SessionFactory sessionFactory;

    public UserPasswordDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(UserPassword userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userPassword);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UserPassword findByUsername(String username) {
        Session session = sessionFactory.openSession();
        UserPassword userPassword = session.createQuery("FROM UserPassword WHERE username = :username", UserPassword.class)
                .setParameter("username", username)
                .uniqueResult();
        session.close();
        return userPassword;
    }

    @Override
    public List<UserPassword> findAll() {
        Session session = sessionFactory.openSession();
        List<UserPassword> userPasswords = session.createQuery("FROM UserPassword", UserPassword.class).list();
        session.close();
        return userPasswords;
    }

    @Override
    public void update(UserPassword userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(userPassword);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(UserPassword userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(userPassword);
        session.getTransaction().commit();
        session.close();
    }
}
