package com.example.practicacomplexivo.controllers;

import com.example.practicacomplexivo.dtos.LoginResponse;
import com.example.practicacomplexivo.dtos.LoginUserDto;
import com.example.practicacomplexivo.dtos.RegisterUserDto;
import com.example.practicacomplexivo.entity.Usuario;
import com.example.practicacomplexivo.services.AuthenticationService;
import com.example.practicacomplexivo.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth")
@RestController

public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> register(@RequestBody RegisterUserDto registerUserDto) {
        Usuario registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Usuario authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        long expiresIn = jwtService.getExpirationTime();

        // Extraer el único rol del usuario autenticado
        String role = authenticatedUser.getRol();

        // Crear la respuesta de login incluyendo el token, el tiempo de expiración y el rol
        LoginResponse loginResponse = new LoginResponse()
                .setToken(jwtToken)
                .setExpiresIn(expiresIn)
                .setRol(role);

        return ResponseEntity.ok(loginResponse);
    }
}
