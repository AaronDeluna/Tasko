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

    private Date deadline;

    @Enumerated(EnumType.STRING)
    private PriorityType priority;

    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "container_id", nullable = false)
    private Container container;

    @PrePersist
    protected void initCreateTime() {
        this.createAt = LocalDateTime.now();
    }

}
