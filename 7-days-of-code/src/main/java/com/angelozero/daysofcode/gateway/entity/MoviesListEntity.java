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
public class MoviesListEntity {

    @JsonProperty("items")
    private List<MovieEntity> moviesList;
}
