package com.skypro.home.controller;

import com.skypro.home.record.SockRecord;
import com.skypro.home.service.SockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SockController {

    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping("/income")
    public ResponseEntity<?> addSocks(@RequestBody SockRecord sockRecord) {

        return sockService.addSocks(sockRecord);
    }

    @PostMapping("/outcome")
    public ResponseEntity<?> removeSocks(@RequestBody SockRecord sockRecord) {

        return sockService.removeSocks(sockRecord);
    }

    @GetMapping
    public ResponseEntity<?> getAmountOfSocks(@RequestParam String color,
                                              String operation,
                                              int cottonPart) {
        return sockService.getAmount(color, operation, cottonPart);
    }
}
