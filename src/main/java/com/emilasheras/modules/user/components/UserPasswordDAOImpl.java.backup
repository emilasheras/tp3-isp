package com.emilasheras.modules.user.components;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.emilasheras.modules.user.models.UserPasswordBackup;

import java.util.List;

public class UserPasswordDAOImpl implements IUserPasswordDAO {
    private SessionFactory sessionFactory;

    public UserPasswordDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(UserPasswordBackup userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userPassword);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UserPasswordBackup findByUsername(String username) {
        Session session = sessionFactory.openSession();
        UserPasswordBackup userPassword = session.createQuery("FROM UserPassword WHERE username = :username", UserPasswordBackup.class)
                .setParameter("username", username)
                .uniqueResult();
        session.close();
        return userPassword;
    }

    @Override
    public List<UserPasswordBackup> findAll() {
        Session session = sessionFactory.openSession();
        List<UserPasswordBackup> userPasswords = session.createQuery("FROM UserPassword", UserPasswordBackup.class).list();
        session.close();
        return userPasswords;
    }

    @Override
    public void update(UserPasswordBackup userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(userPassword);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(UserPasswordBackup userPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(userPassword);
        session.getTransaction().commit();
        session.close();
    }
}
