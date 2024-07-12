package com.alurapractice.challengebooksearch.mapper;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

public record AutorDTO(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Date dateOfBorn,
        @JsonAlias("death_year") Date dateOfDeath
) {
}
