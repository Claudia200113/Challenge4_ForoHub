package com.ForoHub.Repositories;

import com.ForoHub.Models.Entrance;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface IEntranceRepository extends JpaRepository <Entrance, Long> {

    Page<Entrance> findByPublishedTrue();
}
