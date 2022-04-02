package com.angelozero.daysofcode.entrypoint;

import com.angelozero.daysofcode.entrypoint.mapper.ImdbRestMapper;
import com.angelozero.daysofcode.entrypoint.rest.ImdbResponse;
import com.angelozero.daysofcode.usecase.GetListOfListsFromTop250Movies;
import com.angelozero.daysofcode.usecase.GetTop250Movies;
import com.angelozero.daysofcode.usecase.domain.ImdbDomain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@MockitoSettings
class ImdbControllerTest {

    private static final String IMD_CACHE = "IMD_CACHE";
    private static final String CACHE_CLEAR = "Cache clear";
    public static final String MOVIE_TEST = "movie_test";

    @Mock
    private GetTop250Movies getTop250Movies;

    @Mock
    private GetListOfListsFromTop250Movies getListOfListsFromTop250Movies;

    @Mock
    private ImdbRestMapper imdbRestMapper;

    @Mock
    private CacheManager cacheManager;

    @Mock
    private Cache cache;

    @InjectMocks
    ImdbController controller;

    @Test
    @DisplayName("Should clear cache with success")
    void shouldClearCacheWithSuccess() {

        when(cacheManager.getCacheNames()).thenReturn(List.of(IMD_CACHE));
        when(cacheManager.getCache(IMD_CACHE)).thenReturn(cache);
        doNothing().when(cache).clear();

        ResponseEntity<String> value = controller.clearCache();

        assertEquals(HttpStatus.OK, value.getStatusCode());
        assertEquals(CACHE_CLEAR, value.getBody());
    }

    @Test
    @DisplayName("Should get the 250 top movies with success")
    void shouldGetTop250Movies() {

        when(getTop250Movies.execute()).thenReturn(List.of(ImdbDomain.builder().title(MOVIE_TEST).build()));
        when(imdbRestMapper.toResponse(any(ImdbDomain.class))).thenReturn(ImdbResponse.builder().title(MOVIE_TEST).build());

        ResponseEntity<List<ImdbResponse>> value = controller.getTop250Movies();

        assertEquals(HttpStatus.OK, value.getStatusCode());
        assertNotNull(value.getBody());
        assertFalse(value.getBody().isEmpty());
    }

    @Test
    @DisplayName("Should get the 250 top movies in a list of lists with success")
    void shouldGetTop250InAListOfListsMovies() {

        when(getListOfListsFromTop250Movies.execute()).thenReturn(Map.of("property_test", List.of("value_test")));

        ResponseEntity<Map<String, List<String>>> value = controller.getListOfListsFromTop250Movies();

        assertEquals(HttpStatus.OK, value.getStatusCode());
        assertNotNull(value.getBody());
        assertFalse(value.getBody().isEmpty());
    }
}
