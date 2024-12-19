package com.ForoHub.Controllers;

import com.ForoHub.infra.Security.JWTTokenDTO;
import com.ForoHub.DTO.AuthenticationDTO;
import com.ForoHub.Models.User;
import com.ForoHub.infra.Security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    /*@PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.mail()
                ,authenticationDTO.password());
        System.out.println("Debug: Authentication Controller1");
        var authenticatedUser = authenticationManager.authenticate(authenticationToken);
        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        System.out.println("Debug: Authentication Controller2");
        return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));
    }*/

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        try {
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.mail(),
                    authenticationDTO.password());
            var authenticatedUser = authenticationManager.authenticate(authenticationToken);
            var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
            return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

}
