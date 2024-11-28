package com.example.ParcialMutantes.controller;

import com.example.ParcialMutantes.domain.dto.MutantRequestDto;
import com.example.ParcialMutantes.domain.dto.MutantResponseDto;
import com.example.ParcialMutantes.service.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    private final MutantService mutantService;

    public MutantController(MutantService mutantService) { // Inyección de dependencias a través del constructor
        this.mutantService = mutantService;
    }

    @PostMapping
    public ResponseEntity<MutantResponseDto> postMutant( @RequestBody MutantRequestDto mutantRequestDto) {
        try {
            // Guardamos el resultado de si es mutante o no
            boolean isMutant = mutantService.checkDna(mutantRequestDto.getDna());
            // Y seteamos el boolean en el DTO enviado como respuesta
            MutantResponseDto mutantResponseDto = new MutantResponseDto(isMutant);

            // Si es mutante, enviamos un HTTP200 junto al boolean
            if (isMutant) {
                return ResponseEntity.ok().body(mutantResponseDto);
            } else {
                // Si no es mutante, enviamos un HTTP403 junto al boolean
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(mutantResponseDto);
            }
        } catch (Exception e) {
            // Si algo sale mal, enviamos un HTTP400
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
