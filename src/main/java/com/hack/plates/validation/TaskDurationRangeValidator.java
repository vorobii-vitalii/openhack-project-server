package com.hack.plates.validation;

import com.hack.plates.dto.TaskDTO;
import com.hack.plates.entity.Responsibility;
import com.hack.plates.entity.Task;
import com.hack.plates.repository.ResponsibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class TaskDurationRangeValidator implements ConstraintValidator<TaskDurationInRange, TaskDTO> {

    private final ResponsibilityRepository responsibilityRepository;

    @Autowired
    public TaskDurationRangeValidator(ResponsibilityRepository responsibilityRepository) {
        this.responsibilityRepository = responsibilityRepository;
    }

    @Override
    public void initialize(TaskDurationInRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(TaskDTO taskDTO, ConstraintValidatorContext constraintValidatorContext) {
        final Integer providedNumHours = taskDTO.getNumHours();
        Optional<Responsibility> optionalResponsibility = responsibilityRepository.findById(taskDTO.getResponsibilityId());
        if (!optionalResponsibility.isPresent()) return false;
        Responsibility responsibility = optionalResponsibility.get();
        final Integer availableTime = responsibility.getTotalHours();
        Integer hoursSum = 0;
        for (Task task : responsibility.getTasks()) {
            hoursSum += task.getNumHours();
            if ( (availableTime - hoursSum) < providedNumHours )
                return false;
        }
        return true;
    }

}
