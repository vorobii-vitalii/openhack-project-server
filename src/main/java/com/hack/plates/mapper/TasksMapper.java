package com.hack.plates.mapper;

import com.hack.plates.dto.TaskDTO;
import com.hack.plates.entity.Task;
import com.hack.plates.repository.ResponsibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class TasksMapper {

    private final ResponsibilityRepository responsibilityRepository;

    @Autowired
    public TasksMapper(ResponsibilityRepository responsibilityRepository) {
        this.responsibilityRepository = responsibilityRepository;
    }

    @Bean
    public Mapper<Task, TaskDTO> taskDTOMapper() {
        return new Mapper<Task, TaskDTO>() {
            @Override
            public Task from(TaskDTO taskDTO) {
                Task task = new Task();
                task.setId(taskDTO.getId());
                task.setName(taskDTO.getName());
                task.setNumHours(taskDTO.getNumHours());
                task.setResponsibility( responsibilityRepository.getOne(taskDTO.getResponsibilityId())  );
                task.setCreatedAt(taskDTO.getCreatedAt());
                task.setDeadlineAt(taskDTO.getDeadlineAt());
                return task;
            }

            @Override
            public TaskDTO to(Task task) {
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setId(task.getId());
                taskDTO.setName(task.getName());
                taskDTO.setNumHours(task.getNumHours());
                taskDTO.setResponsibilityId(task.getResponsibility().getId());
                taskDTO.setCreatedAt(task.getCreatedAt());
                taskDTO.setDeadlineAt(task.getDeadlineAt());
                return taskDTO;
            }
        };
    }

}
