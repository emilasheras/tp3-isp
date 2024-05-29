package com.emilasheras.modules.user.components;

import java.util.List;

import com.emilasheras.modules.user.models.UserPasswordBackup;

public interface IUserPasswordDAO {
    void save(UserPasswordBackup userPassword);
    UserPasswordBackup findByUsername(String username);
    List<UserPasswordBackup> findAll();
    void update(UserPasswordBackup userPassword);
    void delete(UserPasswordBackup userPassword);
}