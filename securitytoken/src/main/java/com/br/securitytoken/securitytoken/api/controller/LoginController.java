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
import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.services.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getLogin(),
                loginRequest.getPassword());
        var authenticate = this.authenticationManager.authenticate(usernamePassword);
        // Gerando o token para o usuario
        var token = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(token);
    }

}
