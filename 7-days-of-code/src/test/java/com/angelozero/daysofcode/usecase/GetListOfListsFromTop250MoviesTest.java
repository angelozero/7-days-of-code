package com.angelozero.daysofcode.usecase;

import com.angelozero.daysofcode.usecase.domain.ImdbDomain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings
class GetListOfListsFromTop250MoviesTest {

    private static final String IMDB_API_ERROR = "ImdbApi_Error";
    private static final String API_ERROR = "java.lang.RuntimeException: ";

    @Mock
    private GetTop250Movies getTop250Movies;

    @InjectMocks
    GetListOfListsFromTop250Movies getListOfListsFromTop250Movies;

    @Test
    @DisplayName("Should get the top 250 movies in a list of lists with success")
    void shouldGetTheTop250MoviesInAListOfListsWithSuccess() {

        when(getTop250Movies.execute()).thenReturn(List.of(ImdbDomain.builder()
                .title(UUID.randomUUID().toString())
                .crew(UUID.randomUUID().toString())
                .fullTitle(UUID.randomUUID().toString())
                .id(UUID.randomUUID().toString())
                .image(UUID.randomUUID().toString())
                .imDbRating(UUID.randomUUID().toString())
                .imDbRatingCount(UUID.randomUUID().toString())
                .rank(UUID.randomUUID().toString())
                .year(UUID.randomUUID().toString())
                .build()));

        Map<String, List<String>> value = getListOfListsFromTop250Movies.execute();

        assertNotNull(value);
    }

    @Test
    @DisplayName("Should get the top 250 movies in a list of lists with success")
    void shouldGetTheTop250MoviesInAListOfListsWithError() {

        when(getTop250Movies.execute()).thenThrow(new RuntimeException(IMDB_API_ERROR));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> getListOfListsFromTop250Movies.execute());

        assertNotNull(exception);
        assertEquals(API_ERROR + IMDB_API_ERROR, exception.getMessage());
    }
}
