package com.hack.plates.service;

import com.hack.plates.dto.TaskDTO;
import com.hack.plates.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAll();
    TaskDTO getById(Long id);
    TaskDTO getByName(String name);
    TaskDTO update(TaskDTO responsibility);
    void deleteById(Long id);
}
