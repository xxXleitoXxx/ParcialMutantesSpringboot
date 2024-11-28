package com.example.ParcialMutantes.controller;

import com.example.ParcialMutantes.service.StatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) { // Inyección de dependencias a través del constructor
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<?> getStats() {
        try {
            // HTTP200 junto a los stats
            return ResponseEntity.ok().body(statsService.getStats());
        } catch (Exception e) {
            // Si ocurre algún error, se retorna una excepción con HTTP400
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
