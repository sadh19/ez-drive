package com.example.ez_drive.controllers;

import com.example.ez_drive.config.JwtService;
import com.example.ez_drive.models.types.LoginRequest;
import com.example.ez_drive.utils.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ResponseService responseService;


    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, ResponseService responseService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.responseService = responseService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        String jwt = jwtService.generateToken(loginRequest.getUsername());
        return responseService.generateResponse("JWT success", jwt);
    }

}
