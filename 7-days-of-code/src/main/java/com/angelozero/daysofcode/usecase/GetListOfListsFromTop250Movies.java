package com.angelozero.daysofcode.usecase;

import com.angelozero.daysofcode.usecase.domain.MovieDomain;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GetListOfListsFromTop250Movies {

    private final GetTop250Movies getTop250Movies;

    @Cacheable("imdb250MoviesListOfListsCache")
    public Map<String, List<String>> execute() {
        try {
            log.info("\n[INFO] - Getting a list of lists of the 250 top movies\n");

            List<MovieDomain> moviesList = getTop250Movies.execute();

            List<String> id = moviesList.stream().map(MovieDomain::getId).collect(Collectors.toList());
            List<String> rank = moviesList.stream().map(MovieDomain::getRank).collect(Collectors.toList());
            List<String> title = moviesList.stream().map(MovieDomain::getTitle).collect(Collectors.toList());
            List<String> fullTitle = moviesList.stream().map(MovieDomain::getFullTitle).collect(Collectors.toList());
            List<String> year = moviesList.stream().map(MovieDomain::getYear).collect(Collectors.toList());
            List<String> image = moviesList.stream().map(MovieDomain::getImage).collect(Collectors.toList());
            List<String> crew = moviesList.stream().map(MovieDomain::getCrew).collect(Collectors.toList());
            List<String> imDbRating = moviesList.stream().map(MovieDomain::getImDbRating).collect(Collectors.toList());
            List<String> imDbRatingCount = moviesList.stream().map(MovieDomain::getImDbRatingCount).collect(Collectors.toList());

            return Map.of(
                    "id", id,
                    "rank", rank,
                    "title", title,
                    "fullTitle", fullTitle,
                    "year", year,
                    "image", image,
                    "crew", crew,
                    "imDbRating", imDbRating,
                    "imDbRatingCount", imDbRatingCount);

        } catch (Exception ex) {
            log.error("\n[ERROR] - Error to get a list of 250 movies: " + ex.getMessage() + "\n");
            throw new RuntimeException(ex);
        }
    }
}
