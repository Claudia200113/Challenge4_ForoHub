package com.ForoHub.Controllers;

import com.ForoHub.DTO.DataToUpdateDTO;
import com.ForoHub.DTO.ListEntranceDTO;
import com.ForoHub.Models.Entrance;
import com.ForoHub.Repositories.IEntranceRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrance")

public class EntranceController {

    @Autowired
    private IEntranceRepository iEntranceRepository;

    @GetMapping
    public List<ListEntranceDTO> listEntrance(){
        return iEntranceRepository.findAll().stream().map(ListEntranceDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void UpdateEntrance(@RequestBody @Valid DataToUpdateDTO dataToUpdateDTO){
        Entrance entrance = iEntranceRepository.getReferenceById(dataToUpdateDTO.id());
        entrance.UpdateData(dataToUpdateDTO);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public void DeleteEntrance(@PathVariable Long id){
        Entrance entrance = iEntranceRepository.getReferenceById(id);
        entrance.UnpublishEntrance (entrance);

    }

}
