package com.dnoviy.controlSystem.controller;

import com.dnoviy.controlSystem.pojo.LoginRequest;
import com.dnoviy.controlSystem.pojo.SignUpRequest;
import com.dnoviy.controlSystem.service.AuthorizationService;
import com.dnoviy.controlSystem.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    private final RegistrationService registrationService;

    public AuthorizationController(AuthorizationService authorizationService, RegistrationService registrationService) {
        this.authorizationService = authorizationService;
        this.registrationService = registrationService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authorizationService.authorization(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signupRequest) {
        return registrationService.registration(signupRequest);
    }
}
