package org.javaacademy.tasko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private TaskCategory category;

    @Override
    public String toString() {
        return category.name();
    }
}
