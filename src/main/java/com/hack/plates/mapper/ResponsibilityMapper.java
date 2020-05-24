package com.hack.plates.mapper;

import com.hack.plates.dto.ResponsibilityDTO;
import com.hack.plates.dto.ResponsibilityDetailsDTO;
import com.hack.plates.dto.TaskDTO;
import com.hack.plates.entity.Responsibility;
import com.hack.plates.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Component
public class ResponsibilityMapper {

    private final Mapper<Task, TaskDTO> taskDTOMapper;

    @Autowired
    public ResponsibilityMapper(Mapper<Task, TaskDTO> taskDTOMapper) {
        this.taskDTOMapper = taskDTOMapper;
    }

    @Bean
    Mapper<Responsibility, ResponsibilityDTO> responsibilityDTOMapper() {
        return new Mapper<Responsibility, ResponsibilityDTO>() {
            @Override
            public Responsibility from(ResponsibilityDTO responsibilityDTO) {
                Responsibility responsibility = new Responsibility();
                responsibility.setId(responsibilityDTO.getId());
                responsibility.setName(responsibilityDTO.getName());
                responsibility.setTotalHours(responsibilityDTO.getTotalHours());
                return responsibility;
            }

            @Override
            public ResponsibilityDTO to(Responsibility responsibility) {
                ResponsibilityDTO responsibilityDTO = new ResponsibilityDTO();
                responsibilityDTO.setId(responsibility.getId());
                responsibilityDTO.setName(responsibility.getName());
                responsibilityDTO.setTotalHours(responsibility.getTotalHours());
                return responsibilityDTO;
            }
        };
    }

    @Bean
    Mapper<Responsibility, ResponsibilityDetailsDTO> responsibilityDetailsDTOMapper() {
        return new Mapper<Responsibility, ResponsibilityDetailsDTO>() {
            @Override
            public Responsibility from(ResponsibilityDetailsDTO responsibilityDetailsDTO) {
                Responsibility responsibility = new Responsibility();
                responsibility.setId(responsibilityDetailsDTO.getId());
                responsibility.setName(responsibilityDetailsDTO.getName());
                responsibility.setTotalHours(responsibilityDetailsDTO.getTotalHours());
                responsibility.setCreatedBy(responsibilityDetailsDTO.getCreatedBy());

                List<TaskDTO> taskDTOS = responsibilityDetailsDTO.getTasks();

                if (taskDTOS != null)
                    responsibility.setTasks(taskDTOS.stream()
                            .map(taskDTOMapper::from)
                            .collect(Collectors.toList())
                    );
                return responsibility;
            }

            @Override
            public ResponsibilityDetailsDTO to(Responsibility responsibility) {
                ResponsibilityDetailsDTO responsibilityDetailsDTO = new ResponsibilityDetailsDTO();
                responsibilityDetailsDTO.setId(responsibility.getId());
                responsibilityDetailsDTO.setName(responsibility.getName());
                responsibilityDetailsDTO.setTotalHours(responsibility.getTotalHours());
                responsibilityDetailsDTO.setCreatedBy(responsibility.getCreatedBy());

                List<Task> taskList = responsibility.getTasks();

                if (taskList != null)
                    responsibilityDetailsDTO.setTasks(
                            taskList.stream()
                                    .map(taskDTOMapper::to)
                                    .collect(Collectors.toList())
                    );
                return responsibilityDetailsDTO;
            }
        };
    }


}
