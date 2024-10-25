package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "users") // Nom de la table dans la base de données
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour chaque utilisateur

    @Column(name = "username", nullable = false, unique = true)
    private String username; // Nom d'utilisateur unique

    @Column(name = "password", nullable = false)
    private String password; // Mot de passe de l'utilisateur

    @Column(name = "email", nullable = false, unique = true)
    private String email; // Adresse email de l'utilisateur

    @Column(name = "full_name", nullable = false)
    private String fullName; // Nom complet de l'utilisateur

    // Constructeur par défaut
    public User() {
    }

    // Constructeur avec paramètres
    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
