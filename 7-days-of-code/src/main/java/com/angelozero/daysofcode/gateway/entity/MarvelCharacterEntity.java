package com.angelozero.daysofcode.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarvelCharacterEntity {
    private String id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Thumbnail {
        private String path;
        private String extension;
    }
}
