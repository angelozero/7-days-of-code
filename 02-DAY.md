# 02 Day
  - Getting the response from [IMD-API](https://imdb-api.com/api)
  - Returning all the top 250 movies inside of a list of a lists from their parameters
  - Adding Cache for the researches 

## Controller
```java
@GetMapping("/listOFtop250movies")
public ResponseEntity<Map<String, List<String>>> getListOfListsFromTop250Movies() {
    return new ResponseEntity<>(getListOfListsFromTop250Movies.execute(), HttpStatus.OK);
}
```

## Service
  - Adding @Cachable in the GetTop250Movies service
```java
@Cacheable("imdb250MoviesCache")
public List<ImdbDomain> execute() {
    try {
      //...
}
```

- And adding a service to return a list of lists with parameters values
```java
@Cacheable("imdb250MoviesListOfListsCache")
public Map<String, List<String>> execute() {
    try {
        log.info("\n[INFO] - Getting a list of lists of the 250 top movies\n");

        List<ImdbDomain> moviesList = getTop250Movies.execute();

        List<String> id = moviesList.stream().map(ImdbDomain::getId).collect(Collectors.toList());
        List<String> rank = moviesList.stream().map(ImdbDomain::getRank).collect(Collectors.toList());
        List<String> title = moviesList.stream().map(ImdbDomain::getTitle).collect(Collectors.toList());
        List<String> fullTitle = moviesList.stream().map(ImdbDomain::getFullTitle).collect(Collectors.toList());
        List<String> year = moviesList.stream().map(ImdbDomain::getYear).collect(Collectors.toList());
        List<String> image = moviesList.stream().map(ImdbDomain::getImage).collect(Collectors.toList());
        List<String> crew = moviesList.stream().map(ImdbDomain::getCrew).collect(Collectors.toList());
        List<String> imDbRating = moviesList.stream().map(ImdbDomain::getImDbRating).collect(Collectors.toList());
        List<String> imDbRatingCount = moviesList.stream().map(ImdbDomain::getImDbRatingCount).collect(Collectors.toList());

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
```

## Response
```json
[
{
    "imDbRatingCount": [
        "2567646",
        "1767591",
        "2531942"
       
    ],
    "imDbRating": [
        "9.2",
        "9.2",
        "9.0"
       
    ],
    "crew": [
        "Frank Darabont (dir.), Tim Robbins, Morgan Freeman",
        "Francis Ford Coppola (dir.), Marlon Brando, Al Pacino",
        "Christopher Nolan (dir.), Christian Bale, Heath Ledger"
    //...
    ]
}   
```