package com.hack.plates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_hours")
    private Integer numHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="responsibility_id", nullable=false)
    private Responsibility responsibility;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deadline_at")
    private Date deadlineAt;

}
