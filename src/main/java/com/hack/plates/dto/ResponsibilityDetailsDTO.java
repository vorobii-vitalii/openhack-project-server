package com.hack.plates.dto;

import com.hack.plates.entity.Task;
import com.hack.plates.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponsibilityDetailsDTO {

    private Long id;

    private String name;

    private Integer totalHours;

    private User createdBy;

    private List<TaskDTO> tasks;

}
