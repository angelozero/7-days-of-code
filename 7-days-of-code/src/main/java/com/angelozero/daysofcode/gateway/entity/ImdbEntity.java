package com.angelozero.daysofcode.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImdbEntity {
    public String id;
    public String rank;
    public String title;
    public String fullTitle;
    public String year;
    public String image;
    public String crew;
    public String imDbRating;
    public String imDbRatingCount;
}
