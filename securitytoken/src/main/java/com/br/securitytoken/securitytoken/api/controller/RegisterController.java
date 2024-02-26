package com.br.securitytoken.securitytoken.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.securitytoken.securitytoken.api.dto.RegisterRequest;
import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.models.UserRole;
import com.br.securitytoken.securitytoken.domain.repository.UserRepository;

@RestController
@RequestMapping("/register")
public class RegisterController{

    @Autowired
    private UserRepository userRepository;
    
    
    @PostMapping
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest){

    //Verifica se tm algum user dentro do DB.
    if(this.userRepository.findByLogin(registerRequest.getLogin())!= null) return ResponseEntity.badRequest().build();

    String encrytedPassword = new BCryptPasswordEncoder().encode(registerRequest.getPassword());//Codifica a senha
    User newUser = new User(registerRequest.getLogin(), encrytedPassword, UserRole.USER);

    this.userRepository.save(newUser);
    return ResponseEntity.ok().build();

    }
}
