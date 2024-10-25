package com.niladri.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}
