/*
package com.skypro.home.controller;

import com.skypro.home.record.RegisrationRecord;
import com.skypro.home.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public void registration(@RequestBody RegisrationRecord registration) {

        authService.registration(registration);
    }

}
*/
