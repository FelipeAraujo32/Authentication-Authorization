package com.br.securitytoken.securitytoken.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.securitytoken.securitytoken.domain.models.User;
import com.br.securitytoken.securitytoken.domain.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }
    
}
