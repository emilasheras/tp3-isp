package com.emilasheras.modules.user.models;

import com.emilasheras.components.models.CModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "user_password")
public class UserPassword extends CModel {
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "salt", nullable = false)
    private String salt;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}