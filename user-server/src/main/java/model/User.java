package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private String username;
    private String password;
    private String token;
    private LocalDateTime creationDate;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.token = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now(); // Enregistre la date et l'heure actuelles
    }
    
    public User() {
        
    }

    // Getters et Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}