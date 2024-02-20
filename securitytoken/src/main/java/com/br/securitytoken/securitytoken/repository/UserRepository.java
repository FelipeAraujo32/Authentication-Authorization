package com.br.securitytoken.securitytoken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.br.securitytoken.securitytoken.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    public UserDetails findByUser(String user);

}
