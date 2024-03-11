package com.br.securitytoken.securitytoken.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.securitytoken.securitytoken.api.dto.Responses.UserResponse;
import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll(){
        
        List<User> userList = userService.listAll();
            List<UserResponse> userResponses = new ArrayList<>();

            for(User user : userList){
                UserResponse userResponse = new UserResponse(user.getName(), user.getLastname(), user.getNumberPhone(), user.getLogin());
                userResponses.add(userResponse);
            }
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }
    
}
