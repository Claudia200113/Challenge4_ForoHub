package com.ForoHub.Repositories;

import com.ForoHub.Models.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepository extends JpaRepository <Authentication, Long>{

}
