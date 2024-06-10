package com.vti.quizzes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quizzes")
public class Quiz {

    @Id
    private String id;
    private String title;
    private List<Object> questions;
    private String createdBy;
    private String category;
    private String avatar;
    private boolean mustBeSignedIn;
    private String imgUrl;
    private List<Object> comments;
    private String sentFromId;
    private String message;
    private int views;
    private int likes;
    private List<Object> scores;
    private boolean deleted;
    private String createdAt;
    private String updatedAt;

    public Quiz() {

    }

    public Quiz(String title, List<Object> questions, String createdBy, String category) {
        this.title = title;
        this.questions = questions;
        this.createdBy = createdBy;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Object> questions) {
        this.questions = questions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isMustBeSignedIn() {
        return mustBeSignedIn;
    }

    public void setMustBeSignedIn(boolean mustBeSignedIn) {
        this.mustBeSignedIn = mustBeSignedIn;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public String getSentFromId() {
        return sentFromId;
    }

    public void setSentFromId(String sentFromId) {
        this.sentFromId = sentFromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Object> getScores() {
        return scores;
    }

    public void setScores(List<Object> scores) {
        this.scores = scores;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
