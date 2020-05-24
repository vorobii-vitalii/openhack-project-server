package com.hack.plates.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ResponsibilityDTO {

    private Long id;

    @NotBlank
    private String name;

    @Positive
    private Integer totalHours;

}
