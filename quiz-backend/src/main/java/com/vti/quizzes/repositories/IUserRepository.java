package com.vti.quizzes.repositories;

import com.vti.quizzes.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
