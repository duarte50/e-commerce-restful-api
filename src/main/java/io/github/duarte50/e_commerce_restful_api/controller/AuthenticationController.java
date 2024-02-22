package io.github.duarte50.e_commerce_restful_api.controller;

import io.github.duarte50.e_commerce_restful_api.dto.LoginDTO;
import io.github.duarte50.e_commerce_restful_api.dto.AuthenticationDTO;
import io.github.duarte50.e_commerce_restful_api.dto.CreateUserDTO;
import io.github.duarte50.e_commerce_restful_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationDTO> signup(
            @RequestBody CreateUserDTO request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(
            @RequestBody LoginDTO request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
