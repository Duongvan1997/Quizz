package com.vti.quizzes.services;

import com.vti.quizzes.database.SequenceGeneratorService;
import com.vti.quizzes.models.User;
import com.vti.quizzes.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    public User create(User newUser){
        Long id = sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);
        newUser.setId(id);
        return repository.insert(newUser);

    }


    public List<User> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User update(User updateUser) {
        Optional<User> optionalUser = repository.findById(updateUser.getId());
        if(optionalUser.isEmpty()) return null;
        return repository.save(updateUser);
    }

    @Override
    public boolean checkExitsEmail(String email) {
        Optional<User> optionalUserEmail = repository.findByEmail(email);
        if(optionalUserEmail.isEmpty()) return false;
        return true;
    }
}
