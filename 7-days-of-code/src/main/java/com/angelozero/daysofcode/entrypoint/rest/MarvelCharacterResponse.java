package com.angelozero.daysofcode.entrypoint.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarvelCharacterResponse {
    private String id;
    private String name;
    private String description;
    private String image;
}
