package com.vti.quizzes.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "scores")
public class Score {

    @Id
    private String id;
    private String quizId;
    private List<Object> answers;
    private String userId;
    private Date createdAt;
    private boolean deleted;

    public Score() {
        this.createdAt = new Date();
        this.deleted = false;
    }


    public Score(String quizId, List<Object> answers, String userId) {
        this.quizId = quizId;
        this.answers = answers;
        this.userId = userId;
        this.createdAt = new Date();
        this.deleted = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public List<Object> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Object> answers) {
        this.answers = answers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
