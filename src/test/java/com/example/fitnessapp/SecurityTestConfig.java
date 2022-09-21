package com.example.fitnessapp;


import com.example.fitnessapp.entity.User;
import com.example.fitnessapp.security.services.UserDetailsImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@TestConfiguration
public class SecurityTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User simpleUser = new User("simpleUserTest", "user@test.com", "password");
        UserDetailsImpl activeSimpleUser = new UserDetailsImpl(simpleUser.getId(),
                simpleUser.getUsername(),
                simpleUser.getEmail(),
                simpleUser.getPassword(),
                Arrays.asList(
                new SimpleGrantedAuthority("USER")
        ));
        User adminUser = new User("adminTest", "admin@test.com", "password");
        UserDetailsImpl activeAdminUser = new UserDetailsImpl(adminUser.getId(),
                adminUser.getUsername(),
                adminUser.getEmail(),
                adminUser.getPassword(),
                Arrays.asList(
                new SimpleGrantedAuthority("USER"),
                new SimpleGrantedAuthority("ADMIN")
        ));

        return new InMemoryUserDetailsManager(Arrays.asList(
                activeSimpleUser,
                activeAdminUser
        ));
    }
}