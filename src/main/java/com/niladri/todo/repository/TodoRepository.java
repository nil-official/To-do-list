package com.niladri.todo.repository;

import com.niladri.todo.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoList, UUID> {
}
