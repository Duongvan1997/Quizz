package com.vti.quizzes.services;

import com.vti.quizzes.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    public User create(User newUser);
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public Optional<User> findByEmail(String email);
    public User update(User updateUser);

    public boolean checkExitsEmail(String email);
}
