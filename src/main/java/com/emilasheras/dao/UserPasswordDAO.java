package com.emilasheras.dao;

import java.util.List;

import com.emilasheras.modules.user.models.UserPassword;

public interface UserPasswordDAO {
    void save(UserPassword userPassword);
    UserPassword findByUsername(String username);
    List<UserPassword> findAll();
    void update(UserPassword userPassword);
    void delete(UserPassword userPassword);
}
