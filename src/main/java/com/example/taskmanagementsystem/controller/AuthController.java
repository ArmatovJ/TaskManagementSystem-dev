package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.dto.JwtAuthenticationResponse;
import com.example.taskmanagementsystem.dto.SignInRequest;
import com.example.taskmanagementsystem.dto.SignUpRequest;
import com.example.taskmanagementsystem.service.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@Slf4j
public class AuthController {
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        log.info("[#signUp] is calling");
        JwtAuthenticationResponse response = authenticationService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/sign-in")
    public String singIn(@RequestBody @Valid SignInRequest request) {
        log.info("[#signIn] is calling");
        authenticationService.signIn(request);
        return "SUCCESS";
    }
}
