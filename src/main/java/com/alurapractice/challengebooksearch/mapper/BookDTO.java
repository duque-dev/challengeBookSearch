package com.alurapractice.challengebooksearch.mapper;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
         @JsonAlias("title") String name,
         @JsonAlias("authors") List<AutorDTO> author,
         @JsonAlias("languages") List<String> lenguage,
         @JsonAlias("download_count") Double downloads
) {
}
