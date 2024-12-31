package com.ForoHub.Validations;

import com.ForoHub.DTO.EntranceDTO;
import com.ForoHub.Repositories.IEntranceRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateExistingMessageContent implements IValidatorForoHub {

    @Autowired
    private IEntranceRepository entranceRepository;

    public void validateEntrance (EntranceDTO entranceDTO){
        if (entranceRepository.existsEntranceByTitleAndMessage(entranceDTO.title(), entranceDTO.message())){
            throw new ValidationException("An entrance with that title and message already exists");
        }

        if (entranceRepository.existsEntranceByMessage(entranceDTO.message())){
            throw new ValidationException("An entrance with that message already exists");
        }
    }

}
