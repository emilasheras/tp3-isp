package com.emilasheras;

import jakarta.persistence.*;

@Entity // <- this class is an entity and should be mapped to a database table
@Table(name = "user_password") // <- Specifies the table name in the database
public class UserPassword {
    @Id // <- Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <- Auto-increment / auto-generated value
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String salt;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
