package com.ForoHub.infra.Security;

import com.ForoHub.Models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    private JWTVerifier verifier;

    @PostConstruct
    public void initializeVerifier() {
        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        this.verifier = JWT.require(algorithm)
                .withIssuer("ForoHub")
                .build();
    }

    // Generate a new JWT token
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    //.withExpiresAt(generateExpiringHour())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating JWT token", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token cannot be null or blank");
        }

        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            String subject = decodedJWT.getSubject();

            if (subject == null) {
                throw new RuntimeException("Token subject is null");
            }
            return subject;
        } catch (JWTVerificationException exception) {
            System.out.println("Verification Error: " + exception.getMessage());
            throw new RuntimeException("Token verification failed", exception);
        }
    }
}