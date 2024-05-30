package com.emilasheras.modules.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.emilasheras.components.models.CModel;
import com.emilasheras.modules.user_password.models.UserPassword;

@Entity
@Table(name = "user")
public class User extends CModel implements UserInterface{

    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(mappedBy = "user")
    private List<UserPassword> passwords;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public List<UserPassword> getPasswords() {
        return passwords;
    }

    @Override
    public void setPasswords(List<UserPassword> passwords) {
        this.passwords = passwords;
    }
}
