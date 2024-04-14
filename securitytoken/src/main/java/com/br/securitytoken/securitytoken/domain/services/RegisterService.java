package com.br.securitytoken.securitytoken.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.securitytoken.securitytoken.api.dto.Requests.RegisterRequest;
import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.models.UserRole;
import com.br.securitytoken.securitytoken.domain.repository.UserRepository;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> registerService(RegisterRequest registerRequest) {

        // Verifica se tem algum Login existente dentro do DB.
        if (this.userRepository.findByLogin(registerRequest.getLogin()) != null) {
            return ResponseEntity.badRequest().body("Esse login já existe");
        }

        Optional<User> optionalNumberPhone = userRepository.findByNumberPhone(registerRequest.getNumberPhone());
        if (optionalNumberPhone.isPresent()) {
            return ResponseEntity.badRequest().body("Esse número já existe");
        }

        String encrytedPassword = new BCryptPasswordEncoder().encode(registerRequest.getPassword());// Codifica a senha
        User newUser = new User(registerRequest.getName(), registerRequest.getLastname(),
                registerRequest.getNumberPhone(), registerRequest.getLogin(), encrytedPassword, UserRole.USER);

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }

    public ResponseEntity<Object> registerServiceAdmin(RegisterRequest registerRequest) {

        // Verifica se tem algum Login existente dentro do DB.
        if (this.userRepository.findByLogin(registerRequest.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<User> optionalNumberPhone = userRepository.findByNumberPhone(registerRequest.getNumberPhone());
        if (optionalNumberPhone.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        String encrytedPassword = new BCryptPasswordEncoder().encode(registerRequest.getPassword());// Codifica a senha
        
        User newUser = new User(registerRequest.getName(), registerRequest.getLastname(),
                registerRequest.getNumberPhone(), registerRequest.getLogin(), encrytedPassword, UserRole.USER);
        System.out.println(newUser);
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }
}
