package com.vti.quizzes.controllers;

import com.vti.quizzes.jwt.JWTUtility;
import com.vti.quizzes.jwt.JwtInterceptor;
import com.vti.quizzes.models.User;
import com.vti.quizzes.responses.ResponseObject;
import com.vti.quizzes.services.IUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "quizzes/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/findToken")
    public ResponseEntity<?> findByTk(@RequestParam String token) {
        if(token.isBlank()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, null,"token is blank"));
        }
        token = "Bearer " + token;
        boolean isAuthenticated = JwtInterceptor.getInstance().isValidToken(token);
        if(isAuthenticated){
            Claims claims = JWTUtility.getInstance().parseToken(token);
            String email = claims.getSubject();
            if (email != null) {
                Optional<User> user = userService.findByEmail(email);
                if (user.isPresent()) {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, user,"OK"));
                }else {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, null,"user is not exist"));
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, null,"user is not exist"));
    }
}
