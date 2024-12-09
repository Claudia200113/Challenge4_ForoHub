package com.ForoHub.Models;

import com.ForoHub.DTO.AuthenticationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name="user")
@Entity (name="User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String mail;
    private String password;

    public Authentication(AuthenticationDTO authenticationDTO) {
        this.mail = authenticationDTO.mail();
        this.password = authenticationDTO.password();
    }
}
