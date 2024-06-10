package com.vti.quizzes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private Long id;

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    private String name;
    private String email;
    private String password;
    private String avatar;
    private boolean isAdmin;
    private List<String> likedQuizzes = new ArrayList<>();
    private boolean deleted;
    private String access_token;
    private String refresh_token;
    private String createdAt;
    private String updatedAt;

    public User() {
    }

    public User(String name, String email, String password, String avatar, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.isAdmin = isAdmin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getLikedQuizzes() {
        return likedQuizzes;
    }

    public void setLikedQuizzes(List<String> likedQuizzes) {
        this.likedQuizzes = likedQuizzes;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
