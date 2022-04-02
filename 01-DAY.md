# 01 Day
  - Getting the response from [IMD-API](https://imdb-api.com/api)
  - Returning all the top 250 movies

## Controller
```java
@GetMapping("/top250movies")
public ResponseEntity<List<ImdbResponse>> getTop250Movies() {
    List<ImdbResponse> top250MoviesList = getTop250Movies.execute().stream().map(imdbRestMapper::toResponse).collect(Collectors.toList());
    return new ResponseEntity<>(top250MoviesList, HttpStatus.OK);
}
```

## Service
```java
public List<ImdbDomain> execute() {
    try {
        log.info("\n[INFO] - Getting the 250 top movies\n");
        return imdbApiClient.getTop250Movies(imdbProperties.getApiKey())
                .getItems()
                .stream()
                .map(imdbUseCaseMapper::toDomain)
                .collect(Collectors.toList());

    } catch (Exception ex) {
        log.error("\n[ERROR] - IMDB API CLIENT: " + ex.getMessage() + "\n");
        throw new RuntimeException(ex);
    }
}
```

## Gateway
```java
@GetMapping("${imdbApiClient.api.path}")
ImdbListEntity getTop250Movies(@PathVariable("apiKey") String apiKey);
```

## Domain / Entity
```java
//For Client Return I had to use a list called Items
private List<ImdbEntity> items;

// Domain / Entity / Rest-Response returning a list to
public String id;
public String rank;
public String title;
public String fullTitle;
public String year;
public String image;
public String crew;
public String imDbRating;
public String imDbRatingCount;
```

## Response
```json
[
    {
        "id": "string",
        "rank": "1",
        "title": "string",
        "fullTitle": "string",
        "year": "1994",
        "image": "string_.jpg",
        "crew": "string, Morgan Freeman",
        "imDbRating": "9.2",
        "imDbRatingCount": "2567646"
    },
    //...
]
```