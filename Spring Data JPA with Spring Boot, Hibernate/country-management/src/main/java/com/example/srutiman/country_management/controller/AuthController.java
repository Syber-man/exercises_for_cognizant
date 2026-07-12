package com.example.srutiman.country_management.controller;

import com.example.srutiman.country_management.jwt.JwtRequest;
import com.example.srutiman.country_management.jwt.JwtResponse;
import com.example.srutiman.country_management.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil = new JwtUtil();
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUsername());

        return new JwtResponse(token);
    }
}