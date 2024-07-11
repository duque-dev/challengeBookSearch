package com.alurapractice.challengebooksearch.model;

import java.util.Date;
import java.util.List;

public record AutorDTO(
         Date dateOfBorn,
         Date dateOfDeath,
         List<Book>autorBooks
) {
}
