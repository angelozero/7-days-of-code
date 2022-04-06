package com.angelozero.daysofcode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Configuration
public class MarvelProperties {

    @Value("${marvel.private.key}")
    private String privateKey;

    @Value("${marvel.public.key}")
    private String publicKey;

    @Value("${marvel.api.characters.limit}")
    private String limit;

    @Value("${marvel.api.characters.top100Characters}")
    private List<String> top100Characters;
}
