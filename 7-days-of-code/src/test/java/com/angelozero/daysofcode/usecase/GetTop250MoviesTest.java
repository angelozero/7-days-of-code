package com.angelozero.daysofcode.usecase;

import com.angelozero.daysofcode.config.ImdbProperties;
import com.angelozero.daysofcode.gateway.ImdbApiClient;
import com.angelozero.daysofcode.gateway.entity.ImdbEntity;
import com.angelozero.daysofcode.gateway.entity.ImdbListEntity;
import com.angelozero.daysofcode.usecase.domain.ImdbDomain;
import com.angelozero.daysofcode.usecase.mapper.ImdbUseCaseMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.web.client.RestClientException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@MockitoSettings
class GetTop250MoviesTest {

    private static final String API_KEY = "API_KEY";
    private static final String TITLE_MOVIE_TEST = "title_movie_test";
    private static final String API_ERROR = "org.springframework.web.client.RestClientException: ";
    private static final String IMDB_API_ERROR = "ImdbApi_Error";

    @Mock
    private ImdbApiClient imdbApiClient;

    @Mock
    private ImdbProperties imdbProperties;

    @Mock
    private ImdbUseCaseMapper imdbUseCaseMapper;

    @InjectMocks
    private GetTop250Movies getTop250Movies;

    @Test
    @DisplayName("Should get the top 250 movies with success")
    void shouldGetTop250MoviesWithSuccess() {

        ImdbEntity imdbEntity = ImdbEntity.builder().title(TITLE_MOVIE_TEST).build();
        ImdbDomain imdbDomain = ImdbDomain.builder().title(TITLE_MOVIE_TEST).build();

        when(imdbApiClient.getTop250Movies(anyString()))
                .thenReturn(ImdbListEntity.builder()
                        .items(List.of(imdbEntity))
                        .build());
        when(imdbProperties.getApiKey()).thenReturn(API_KEY);
        when(imdbUseCaseMapper.toDomain(any(ImdbEntity.class))).thenReturn(imdbDomain);

        List<ImdbDomain> value = getTop250Movies.execute();

        assertNotNull(value);
        assertFalse(value.isEmpty());
    }

    @Test
    @DisplayName("Should get the top 250 movies with error")
    void shouldGetTop250MoviesWithError() {

        when(imdbApiClient.getTop250Movies(anyString())).thenThrow(new RestClientException(IMDB_API_ERROR));
        when(imdbProperties.getApiKey()).thenReturn(API_KEY);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getTop250Movies.execute());

        assertNotNull(exception);
        assertEquals(API_ERROR + IMDB_API_ERROR, exception.getMessage());
    }
}

