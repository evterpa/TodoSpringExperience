package org.example.todolist.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String description;

    private boolean completed;

    @Getter
    private LocalDateTime createdAt;

    public ToDo(){
        this.createdAt = LocalDateTime.now();
    }

    public ToDo(String description){
        this();
        this.description = description;
    }

}
