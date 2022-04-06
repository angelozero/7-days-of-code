package com.angelozero.daysofcode.entrypoint;

import com.angelozero.daysofcode.entrypoint.mapper.MarvelRestMapper;
import com.angelozero.daysofcode.entrypoint.rest.MarvelCharacterResponse;
import com.angelozero.daysofcode.usecase.GetMarvelCharacters;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/marvel")
@AllArgsConstructor
public class MarvelController {

    private static final String CACHE_CLEAR = "Cache clear";

    private final GetMarvelCharacters getMarvelCharacters;
    private final MarvelRestMapper marvelRestMapper;
    private final CacheManager cacheManager;

    @GetMapping("/clear")
    public ResponseEntity<String> clearCache() {
        for (String name : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(name)).clear();
        }
        return new ResponseEntity<>(CACHE_CLEAR, HttpStatus.OK);
    }

    @GetMapping("/characters")
    public ResponseEntity<List<MarvelCharacterResponse>> getMarvelCharacters(@PathParam("name") final String name) {
        return new ResponseEntity<>(getMarvelCharacters.execute(name)
                .stream()
                .map(marvelRestMapper::toResponse).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}

