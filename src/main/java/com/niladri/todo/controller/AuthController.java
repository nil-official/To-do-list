package com.niladri.todo.controller;

import com.niladri.todo.dto.request.LoginRequest;
import com.niladri.todo.dto.request.RegisterRequest;
import com.niladri.todo.dto.response.AuthResponse;
import com.niladri.todo.dto.response.RegisterResponse;
import com.niladri.todo.exception.UserException;
import com.niladri.todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws UserException {
        RegisterResponse response = userService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
