package com.br.securitytoken.securitytoken.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.br.securitytoken.securitytoken.domain.repository.UserRepository;

@Service
public class UserServiceAuthorization implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String login) throws UsernameNotFoundException{
        return userRepository.findByLogin(login);
    }
}
