package com.alurapractice.challengebooksearch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
         @JsonAlias("title") String name,
         @JsonAlias("languages") String lenguage,
         @JsonAlias("download_count") int downloads
) {
}
