package com.br.securitytoken.securitytoken.domain.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.br.securitytoken.securitytoken.domain.models.User;

@Service
public class TokenService {

    //Chave para segurança adicional
    @Value("${api.security.token.secretkey}")
    private String secretkey;
   
    //Gerador de Token
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretkey);
            String token = JWT.create()
                    .withIssuer("security-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException exception) {
           throw new RuntimeException("Error while generating token", exception);
        }
    }

    //Validação do Token gerado pelo generateToken
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretkey);
            return JWT.require(algorithm)  
                .withIssuer("security-api")
                .build()
                .verify(token)
                .getSubject();

        } catch (JWTVerificationException exception) {
            return "SEM TOKEN";   
        }
    }

    // Runtime para gerenciar o tempo de validade do token
    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
