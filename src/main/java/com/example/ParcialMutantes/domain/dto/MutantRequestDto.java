package com.example.ParcialMutantes.domain.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MutantRequestDto {

    private String[] dna;
}
