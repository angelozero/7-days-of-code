package com.angelozero.daysofcode.gateway.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarvelCharacterDataEntity {

    @JsonProperty("data")
    private MarvelCharactersResultsEntityList marvelCharactersResultsEntityList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MarvelCharactersResultsEntityList {
        @JsonProperty("results")
        List<MarvelCharacterEntity> marvelCharacterEntityList;
    }
}
