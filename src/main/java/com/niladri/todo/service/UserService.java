package com.niladri.todo.service;

import com.niladri.todo.dto.request.LoginRequest;
import com.niladri.todo.dto.request.RegisterRequest;
import com.niladri.todo.dto.response.AuthResponse;
import com.niladri.todo.dto.response.RegisterResponse;
import com.niladri.todo.exception.UserException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest) throws UserException;
    AuthResponse login(LoginRequest loginRequest);
}
