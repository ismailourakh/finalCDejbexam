package com.example.controller;

import com.example.entity.User;
import com.example.dto.UserData;
import com.example.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserController {

    @Inject
    private UserService userService; // Service pour les opérations utilisateur

    private List<UserData> userList; // Liste des utilisateurs affichée dans la vue
    private UserData selectedUser; // Utilisateur sélectionné pour les opérations

    @PostConstruct
    public void init() {
        userList = userService.findAllUsers(); // Chargement de la liste des utilisateurs
    }

    // Méthode pour emprunter un livre
    public String borrowBook(UserData user, String bookId) {
        userService.borrowBook(user.getId(), bookId); // Appel au service pour emprunter un livre
        return "userList?faces-redirect=true"; // Redirection vers la liste des utilisateurs
    }

    // Méthode pour supprimer un utilisateur
    public String delete(UserData user) {
        userService.deleteUser(user.getId()); // Appel au service pour supprimer l'utilisateur
        userList = userService.findAllUsers(); // Rechargement de la liste après suppression
        return null; // Reste sur la même page
    }

    // Getters et Setters
    public List<UserData> getUserList() {
        return userList;
    }

    public void setUserList(List<UserData> userList) {
        this.userList = userList;
    }

    public UserData getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserData selectedUser) {
        this.selectedUser = selectedUser;
    }
}
