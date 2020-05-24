package com.hack.plates.controller;

import com.hack.plates.dto.ResponsibilityDTO;
import com.hack.plates.dto.ResponsibilityDetailsDTO;
import com.hack.plates.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/responsibilities")
public class ResponsibilityController {

    private final ResponsibilityService responsibilityService;

    @Autowired
    public ResponsibilityController(ResponsibilityService responsibilityService) {
        this.responsibilityService = responsibilityService;
    }

    @GetMapping
    public List<ResponsibilityDTO> getAll() {
        return responsibilityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponsibilityDetailsDTO getById(@PathVariable("id") Long id) {
        return responsibilityService.getById(id);
    }

    @PostMapping
    public ResponsibilityDetailsDTO add( @Valid @RequestBody ResponsibilityDTO responsibility) {
        responsibility.setId(0L);
        return responsibilityService.update(responsibility);
    }

    @PutMapping
    public ResponsibilityDetailsDTO update( @Valid @RequestBody ResponsibilityDTO responsibility) {
        return responsibilityService.update(responsibility);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        responsibilityService.deleteById(id);
    }


}
