package com.niladri.todo.config;

import com.niladri.todo.model.Role;
import com.niladri.todo.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleInitializer implements CommandLineRunner {

    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create ROLE_USER if it doesn't exist
        if (!roleRepository.existsByName("ROLE_USER")) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
        // Create ROLE_ADMIN if it doesn't exist
        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }
    }
}
