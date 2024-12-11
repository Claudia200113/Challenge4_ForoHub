package com.ForoHub.Controllers;

import com.ForoHub.DTO.AuthenticationDTO;
import com.ForoHub.Models.User;
import com.ForoHub.Repositories.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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


   /* @PostMapping
    public void Authenticate(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        iUserRepository.save(new User(authenticationDTO));
    }*/

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        Authentication token = new UsernamePasswordAuthenticationToken(authenticationDTO.mail()
                ,authenticationDTO.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
