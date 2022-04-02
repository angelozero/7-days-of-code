package com.angelozero.daysofcode.entrypoint;

import com.angelozero.daysofcode.entrypoint.mapper.ImdbRestMapper;
import com.angelozero.daysofcode.entrypoint.rest.ImdbResponse;
import com.angelozero.daysofcode.usecase.GetListOfListsFromTop250Movies;
import com.angelozero.daysofcode.usecase.GetTop250Movies;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/api")
@AllArgsConstructor
public class ImdbController {

    private final GetTop250Movies getTop250Movies;
    private final GetListOfListsFromTop250Movies getListOfListsFromTop250Movies;
    private final ImdbRestMapper imdbRestMapper;
    private final CacheManager cacheManager;

    @GetMapping("/clear")
    public void clearCache() {
        for (String name : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(name)).clear();
        }
    }

    @GetMapping("/top250movies")
    public ResponseEntity<List<ImdbResponse>> getTop250Movies() {
        List<ImdbResponse> top250MoviesList = getTop250Movies.execute().stream().map(imdbRestMapper::toResponse).collect(Collectors.toList());
        return new ResponseEntity<>(top250MoviesList, HttpStatus.OK);
    }

    @GetMapping("/listOFtop250movies")
    public ResponseEntity<Map<String, List<String>>> getListOfListsFromTop250Movies() {
        return new ResponseEntity<>(getListOfListsFromTop250Movies.execute(), HttpStatus.OK);
    }
}
