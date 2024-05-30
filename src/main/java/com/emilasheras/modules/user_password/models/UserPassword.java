package com.emilasheras.modules.user_password.models;

import com.emilasheras.components.models.CModel;
import com.emilasheras.modules.user.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "user_password")
public class UserPassword extends CModel implements UserPasswordInterface {
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "salt", nullable = false)
    private String salt;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getSalt() {
        return salt;
    }

    @Override
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}