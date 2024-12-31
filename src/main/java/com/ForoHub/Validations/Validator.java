package com.ForoHub.Validations;

import com.ForoHub.DTO.EntranceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validator {

    @Autowired
    private List<IValidatorForoHub> validators;

    public void EntranceValidators (EntranceDTO entranceDTO){
        validators.forEach(v -> v.validateEntrance(entranceDTO));
    }
}
