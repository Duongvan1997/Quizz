package com.vti.quizzes.repositories;

import com.vti.quizzes.models.Quiz;
import com.vti.quizzes.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IQuizzRepository extends MongoRepository<Quiz, Long> {
}
