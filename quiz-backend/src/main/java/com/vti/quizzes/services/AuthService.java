package com.vti.quizzes.services;

import com.vti.quizzes.jwt.JWTUtility;
import com.vti.quizzes.models.User;
import com.vti.quizzes.repositories.IUserRepository;
import com.vti.quizzes.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final IUserRepository userRepository;
    @Autowired
    public AuthService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public String loginWithEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        assert user != null;
        if (PasswordEncoder.getInstance().matches(password, user.getPassword())) {
            return JWTUtility.getInstance().generateTokenWithEmail(email);
        }
        return null;
    }
}