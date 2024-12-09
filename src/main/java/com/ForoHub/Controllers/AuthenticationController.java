package com.ForoHub.Controllers;

import com.ForoHub.DTO.AuthenticationDTO;
import com.ForoHub.Models.Authentication;
import com.ForoHub.Repositories.IAuthenticationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")

public class AuthenticationController {

    @Autowired
    private IAuthenticationRepository authenticationRepository;

    @PostMapping
    public void Authenticate(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        authenticationRepository.save(new Authentication(authenticationDTO));
    }
}
