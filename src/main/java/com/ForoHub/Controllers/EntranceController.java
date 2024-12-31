package com.ForoHub.Controllers;

import com.ForoHub.DTO.*;
import com.ForoHub.Models.Entrance;
import com.ForoHub.Repositories.IEntranceRepository;
import com.ForoHub.Validations.Validator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/entrance")
@SecurityRequirement(name = "bearer-key")

public class EntranceController {

    @Autowired
    private IEntranceRepository iEntranceRepository;

    @Autowired
    private Validator validator;

    @PostMapping
    public ResponseEntity <ResponseEntranceDTO> registerEntrance(@RequestBody EntranceDTO entranceDTO, UriComponentsBuilder uriComponentsBuilder) {
            validator.EntranceValidators(entranceDTO);
            Entrance entrance = iEntranceRepository.save(new Entrance(entranceDTO));
            ResponseEntranceDTO responseEntranceDTO = new ResponseEntranceDTO(entrance.getId(), entrance.getTitle(),
                    entrance.getMessage(),entrance.getCreationDate(),entrance.getPublished(),entrance.getAuthor(),entrance.getReplies(),
                    entrance.getCourse());
            URI url = uriComponentsBuilder.path("/entrance/{id}").buildAndExpand(entrance.getId()).toUri();
            return ResponseEntity.created(url).body(responseEntranceDTO);
    }

    @GetMapping
    public Page<ListEntranceDTO> listEntrance(@PageableDefault(size = 10) Pageable pagination) {
        return iEntranceRepository.findByPublishedTrue(pagination).map(ListEntranceDTO::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity UpdateEntrance(@RequestBody @Valid DataToUpdateDTO dataToUpdateDTO){
        Entrance entrance = iEntranceRepository.getReferenceById(dataToUpdateDTO.id());
        entrance.UpdateData(dataToUpdateDTO);
        ResponseEntranceDTO response = new ResponseEntranceDTO(entrance.getId(), entrance.getTitle(),
                entrance.getMessage(),entrance.getCreationDate(),entrance.getPublished(),entrance.getAuthor(),entrance.getReplies(),
                entrance.getCourse());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity DeleteEntrance(@PathVariable Long id){
        Entrance entrance = iEntranceRepository.getReferenceById(id);
        entrance.UnpublishEntrance();
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public Optional<Entrance> SingleEntrance(@PathVariable Long id) {
        return iEntranceRepository.findById(id);
    }

}
