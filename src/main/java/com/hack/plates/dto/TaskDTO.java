package com.hack.plates.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hack.plates.validation.TaskDurationInRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TaskDurationInRange
public class TaskDTO {

    private Long id;

    @NotEmpty
    private String name;

    @Positive
    private Integer numHours;

    @Positive
    private Long responsibilityId;

    @FutureOrPresent
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @Future
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date deadlineAt;

}
