package org.javaacademy.tasko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subtask {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaskStatus taskStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updated_at;

}
