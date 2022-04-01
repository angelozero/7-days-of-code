package com.angelozero.daysofcode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ImdbProperties {

    @Value("${imdb.apikey}")
    private String apiKey;
}
