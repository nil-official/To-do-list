package com.niladri.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoList> todoLists = new ArrayList<>();
}
