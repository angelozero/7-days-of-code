package com.angelozero.daysofcode.usecase.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarvelCharacterDomain {
    private String id;
    private String name;
    private String description;
    private String image;
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
