package com.ForoHub.Repositories;

import com.ForoHub.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Long> {

    UserDetails findByMail(String username);
}
