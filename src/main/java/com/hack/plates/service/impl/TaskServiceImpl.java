package com.hack.plates.service.impl;

import com.hack.plates.dto.TaskDTO;
import com.hack.plates.entity.Task;
import com.hack.plates.exceptions.tasks.TaskNotFoundException;
import com.hack.plates.mapper.Mapper;
import com.hack.plates.repository.TaskRepository;
import com.hack.plates.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDTO> taskDTOMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, Mapper<Task, TaskDTO> taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
    }

    @Override
    public List<TaskDTO> getAll() {
        return taskRepository.findAll().stream()
                .map(taskDTOMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " was not found"));
        return taskDTOMapper.to(task);
    }

    @Override
    public TaskDTO getByName(String name) {
        Task task = taskRepository.findByName(name)
                .orElseThrow(() -> new TaskNotFoundException("Task with name " + name + " was not found"));
        return taskDTOMapper.to(task);
    }

    @Override
    public TaskDTO update(TaskDTO responsibility) {
        Task taskToSave = taskDTOMapper.from(responsibility);
        Task task = taskRepository.save( taskToSave );
        return taskDTOMapper.to(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
