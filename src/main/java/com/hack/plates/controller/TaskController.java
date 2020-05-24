package com.hack.plates.controller;

import com.hack.plates.dto.TaskDTO;
import com.hack.plates.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable("id") Long id) {
        return taskService.getById(id);
    }

    @PostMapping
    public TaskDTO add(@Valid @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(0L);
        taskDTO.setCreatedAt(new Date());
        System.out.println(taskDTO);
        return taskService.update(taskDTO);
    }

    @PutMapping
    public TaskDTO update(@Valid @RequestBody TaskDTO taskDTO) {
        taskDTO.setCreatedAt(new Date());
        return taskService.update(taskDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        taskService.deleteById(id);
    }

}
