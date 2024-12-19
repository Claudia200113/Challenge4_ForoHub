package com.ForoHub.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        String mail,
        String password) {
}
