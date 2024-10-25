package com.niladri.todo.dto.response;

import com.niladri.todo.model.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
public class RegisterResponse {
    private String message;
    private String username;
    private Set<Role> roles;
    private LocalDateTime creationTime;
}
