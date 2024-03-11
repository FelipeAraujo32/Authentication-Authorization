package com.br.securitytoken.securitytoken.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.securitytoken.securitytoken.api.dto.Requests.LoginRequest;
import com.br.securitytoken.securitytoken.domain.services.LoginService;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        var token = loginService.loginService(loginRequest);
        return ResponseEntity.ok(token);
    }


}
