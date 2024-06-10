package com.vti.quizzes.controllers;
import com.vti.quizzes.jwt.JwtTokenStore;
import com.vti.quizzes.models.User;
import com.vti.quizzes.request.LoginRequest;
import com.vti.quizzes.responses.ResponseObject;
import com.vti.quizzes.security.PasswordEncoder;
import com.vti.quizzes.services.AuthService;
import com.vti.quizzes.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "quizzes/auth")
public class AuthController {
    @Autowired
    IUserService userService;
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> singUp(@RequestBody User user){
        boolean checkExits = userService.checkExitsEmail(user.getEmail());
        if (checkExits){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, null,"Email already exists."));
        }
        user.setPassword(PasswordEncoder.getInstance().encodePassword(user.getPassword()));
        User newUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, newUser, "success"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> singIn(@RequestBody LoginRequest loginRequest){
        Optional<User> optionalUser = userService.findByEmail(loginRequest.getEmail());
        if(optionalUser == null || !PasswordEncoder.getInstance().matches(loginRequest.getPassword(), optionalUser.get().getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, loginRequest,"Login Fail!"));
        };

        String token = authService.loginWithEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        JwtTokenStore.getInstance().storeToken(loginRequest.getEmail(), token);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, optionalUser,token));
    }

}
