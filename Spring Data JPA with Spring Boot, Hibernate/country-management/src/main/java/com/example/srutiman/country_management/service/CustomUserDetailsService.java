package com.example.srutiman.country_management.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if (username.equals("admin")) {

            return User.withUsername("admin")
                    .password("admin123")
                    .roles("ADMIN", "USER")
                    .build();

        }

        if (username.equals("user")) {

            return User.withUsername("user")
                    .password("user123")
                    .roles("USER")
                    .build();

        }

        throw new UsernameNotFoundException("User not found");
    }
}