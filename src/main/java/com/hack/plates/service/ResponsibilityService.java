package com.hack.plates.service;

import com.hack.plates.dto.ResponsibilityDTO;
import com.hack.plates.dto.ResponsibilityDetailsDTO;

import java.util.List;

public interface ResponsibilityService {
    List<ResponsibilityDTO> getAll();
    ResponsibilityDetailsDTO getById(Long id);
    ResponsibilityDetailsDTO getByName(String name);
    ResponsibilityDetailsDTO update(ResponsibilityDTO responsibility);
    void deleteById(Long id);
}
