package com.hack.plates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse <T> {
    private T cause;
    private Integer status;
    private Long timestamp;
}
