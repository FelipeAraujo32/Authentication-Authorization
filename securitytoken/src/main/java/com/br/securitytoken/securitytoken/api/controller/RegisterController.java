package com.br.securitytoken.securitytoken.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.securitytoken.securitytoken.api.dto.Requests.RegisterRequest;
import com.br.securitytoken.securitytoken.domain.services.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController{

    @Autowired
    private RegisterService registerService;
    
    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterRequest registerRequest){
        var response = registerService.registerService(registerRequest);
        return response;
    }

    @PostMapping("/admin")
    public ResponseEntity<Object> registerAdmin(@RequestBody @Valid RegisterRequest registerRequest){
        var response = registerService.registerServiceAdmin(registerRequest);
        return response;

    }
}
