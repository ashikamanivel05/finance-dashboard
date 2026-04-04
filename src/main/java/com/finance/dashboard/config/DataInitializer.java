package com.finance.dashboard.config;

import com.finance.dashboard.entity.Role;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner setupData(UserRepository userRepository) {
        return args -> {
            // Create Admin
            if (userRepository.findByEmail("admin@finance.com").isEmpty()) {
                User admin = new User();
                admin.setName("System Admin");
                admin.setEmail("admin@finance.com");
                admin.setPassword("admin123"); 
                admin.setRole(Role.ADMIN);
                admin.setActive(true);
                userRepository.save(admin);
            }

           //create Viewer
            if (userRepository.findByEmail("viewer@finance.com").isEmpty()) {
                User viewer = new User();
                viewer.setName("Guest Viewer");
                viewer.setEmail("viewer@finance.com");
                viewer.setPassword("viewer123");
                viewer.setRole(Role.VIEWER);
                viewer.setActive(true);
                userRepository.save(viewer);
            }
            
            //create Analyst
            
            if (userRepository.findByEmail("analyst@finance.com").isEmpty()) {
                User analyst = new User();
                analyst.setName("Data Analyst");
                analyst.setEmail("analyst@finance.com");
                analyst.setPassword("analyst123");
                analyst.setRole(Role.ANALYST);
                analyst.setActive(true);
                userRepository.save(analyst);
            }
            
            System.out.println("--- Demo Users Created: admin@finance.com / admin123 ---");
        };
    }
}