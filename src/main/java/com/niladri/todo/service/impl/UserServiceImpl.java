package com.niladri.todo.service.impl;

import com.niladri.todo.dto.request.LoginRequest;
import com.niladri.todo.dto.request.RegisterRequest;
import com.niladri.todo.dto.response.AuthResponse;
import com.niladri.todo.dto.response.RegisterResponse;
import com.niladri.todo.exception.RoleException;
import com.niladri.todo.exception.UserException;
import com.niladri.todo.model.Role;
import com.niladri.todo.model.User;
import com.niladri.todo.repository.RoleRepository;
import com.niladri.todo.repository.UserRepository;
import com.niladri.todo.service.UserService;
import com.niladri.todo.utility.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws UserException {
        try {
            // Check if username or email already exists
            boolean isExists = userRepository.existsByUsername(registerRequest.getUsername());
            if (isExists)
                throw new UserException("Username already exists! Please try again with a different username.");

            // Creating new user
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RoleException("User Role not found!"));
            roles.add(userRole);
            user.setRoles(roles);
            User savedUser = userRepository.save(user);

            // Returning response
            return new RegisterResponse(
                    "User registered successfully",
                    savedUser.getUsername(),
                    savedUser.getRoles(),
                    savedUser.getCreationTime()
            );
        } catch (UserException e) {
            throw new UserException(e.getMessage());
        } catch (RoleException e) {
            throw new RoleException(e.getMessage());
        } catch (Exception e) {
            throw new UserException("An error occurred while registering user! Please try again.");
        }
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication);

        // Get user roles
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new AuthResponse(
                token,
                jwtUtil.getJwtPrefix(),
                loginRequest.getUsername(),
                roles,
                jwtUtil.getExpirationFromToken(token)
        );
    }
}