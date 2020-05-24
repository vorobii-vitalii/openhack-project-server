package com.hack.plates.service.impl;

import com.hack.plates.dto.ResponsibilityDTO;
import com.hack.plates.dto.ResponsibilityDetailsDTO;
import com.hack.plates.entity.Responsibility;
import com.hack.plates.exceptions.responsibilities.ResponsibilityNotFoundException;
import com.hack.plates.mapper.Mapper;
import com.hack.plates.repository.ResponsibilityRepository;
import com.hack.plates.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponsibilityServiceImpl implements ResponsibilityService {

    private final ResponsibilityRepository responsibilityRepository;
    private final Mapper<Responsibility, ResponsibilityDTO> responsibilityDTOMapper;
    private final Mapper<Responsibility, ResponsibilityDetailsDTO> responsibilityDetailsDTOMapper;

    @Autowired
    public ResponsibilityServiceImpl(ResponsibilityRepository responsibilityRepository,
                                     Mapper<Responsibility, ResponsibilityDTO> responsibilityDTOMapper,
                                     Mapper<Responsibility, ResponsibilityDetailsDTO> responsibilityDetailsDTOMapper) {
        this.responsibilityRepository = responsibilityRepository;
        this.responsibilityDTOMapper = responsibilityDTOMapper;
        this.responsibilityDetailsDTOMapper = responsibilityDetailsDTOMapper;
    }

    @Override
    public List<ResponsibilityDTO> getAll() {
        return responsibilityRepository.findAll()
                .stream()
                .map(responsibilityDTOMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public ResponsibilityDetailsDTO getById(Long id) {
        Responsibility responsibility = responsibilityRepository
                .findById(id)
                .orElseThrow(() -> new ResponsibilityNotFoundException("Responsibility with id " + id + " was not found"));
        return responsibilityDetailsDTOMapper.to(responsibility);
    }

    @Override
    public ResponsibilityDetailsDTO getByName(String name) {
        Responsibility responsibility = responsibilityRepository
                .findByName(name)
                .orElseThrow(() -> new ResponsibilityNotFoundException("Responsibility with name " + name + " was not found"));
        return responsibilityDetailsDTOMapper.to(responsibility);
    }

    @Override
    public ResponsibilityDetailsDTO update(ResponsibilityDTO responsibility) {
        Responsibility savedResp = responsibilityRepository.save( responsibilityDTOMapper.from(responsibility) );
        return responsibilityDetailsDTOMapper.to(savedResp);
    }

    @Override
    public void deleteById(Long id) {
        responsibilityRepository.deleteById(id);
    }
}
