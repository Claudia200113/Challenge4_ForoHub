package com.ForoHub.Controllers;

import com.ForoHub.DTO.CourseDTO;
import com.ForoHub.DTO.DataToUpdateDTO;
import com.ForoHub.DTO.ListEntranceDTO;
import com.ForoHub.DTO.ResponseEntranceDTO;
import com.ForoHub.Models.Entrance;
import com.ForoHub.Repositories.IEntranceRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrance")

public class EntranceController {

    @Autowired
    private IEntranceRepository iEntranceRepository;

    @GetMapping
    public Page<ListEntranceDTO> listEntrance(@PageableDefault(size = 5) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return iEntranceRepository.findByPublishedTrue(paginacion).map(ListEntranceDTO::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity UpdateEntrance(@RequestBody @Valid DataToUpdateDTO dataToUpdateDTO){
        Entrance entrance = iEntranceRepository.getReferenceById(dataToUpdateDTO.id());
        entrance.UpdateData(dataToUpdateDTO);
        ResponseEntranceDTO response = new ResponseEntranceDTO(entrance.getId(), entrance.getTitle(),
                entrance.getMessage(),entrance.getCreationDate(),entrance.getAuthor(),entrance.getReplies(),
                entrance.getReplies(), entrance.getCourse());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity DeleteEntrance(@PathVariable Long id){
        Entrance entrance = iEntranceRepository.getReferenceById(id);
        entrance.UnpublishEntrance ();
        return ResponseEntity.noContent().build();
    }

}
