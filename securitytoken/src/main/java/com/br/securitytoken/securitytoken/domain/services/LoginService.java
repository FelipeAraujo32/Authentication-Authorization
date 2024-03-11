package com.br.securitytoken.securitytoken.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.br.securitytoken.securitytoken.api.dto.Requests.LoginRequest;
import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.repository.UserRepository;

@Service
public class LoginService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String loginService(LoginRequest loginRequest) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword());
        var authenticate = authenticationManager.authenticate(usernamePassword);
        
        // Gerando o token para o usuario
        var token = tokenService.generateToken((User) authenticate.getPrincipal());
        
        return token;
    }
    
}
