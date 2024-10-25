package com.niladri.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "todolists")
public class TodoList {
    @Id
    @GeneratedValue
    private UUID id;

    @JsonIgnore
    @ManyToOne
    private Todo todo;

    private String title;
    private String description;
    private boolean done;
}
