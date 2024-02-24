package com.br.securitytoken.securitytoken.api.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.securitytoken.securitytoken.api.dto.LoginRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("user")
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword());
        var authenticated = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

}
