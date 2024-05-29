package com.emilasheras.modules.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.emilasheras.components.models.CModel;

@Entity
@Table(name = "user")
public class User extends CModel {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user")
    private List<UserPassword> passwords;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserPassword> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<UserPassword> passwords) {
        this.passwords = passwords;
    }
}
