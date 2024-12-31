package com.ForoHub.Repositories;

import com.ForoHub.Models.Entrance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.Optional;

public interface IEntranceRepository extends JpaRepository <Entrance, Long> {

    Page<Entrance> findByPublishedTrue(Pageable pageable);

    @Override
    Optional<Entrance> findById(Long id);

    boolean existsEntranceByTitleAndMessage (String title, String Message);

    boolean existsEntranceByMessage (String Message);

}
