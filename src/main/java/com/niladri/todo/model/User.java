package com.niladri.todo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private LocalDateTime creationTime;
    private LocalDateTime lastModifiedTime;

    @PrePersist
    protected void onCreate() {
        creationTime = LocalDateTime.now();
        lastModifiedTime = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        lastModifiedTime = LocalDateTime.now();
    }
}
