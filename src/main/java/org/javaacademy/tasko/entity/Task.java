package org.javaacademy.tasko.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private PriorityType priority;

    @ManyToOne
    @JoinColumn(name = "column_id", nullable = false)
    private TaskColumn taskColumn;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @PrePersist
    protected void noCreate() {
        this.createAt = LocalDateTime.now();
    }

    public Task(String title, String description, Date dueDate, PriorityType priority, Integer position) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.position = position;
    }
}
