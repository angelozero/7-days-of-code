package com.angelozero.daysofcode.usecase;

import com.angelozero.daysofcode.config.MarvelProperties;
import com.angelozero.daysofcode.gateway.MarvelApiClient;
import com.angelozero.daysofcode.gateway.entity.MarvelCharacterDataEntity;
import com.angelozero.daysofcode.usecase.domain.MarvelCharacterDomain;
import com.angelozero.daysofcode.usecase.mapper.MarvelUseCaseMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class GetMarvelCharacters {

    private final MarvelApiClient marvelApiClient;
    private final MarvelProperties marvelProperties;
    private final MarvelUseCaseMapper marvelUseCaseMapper;

    public List<MarvelCharacterDomain> execute(String characterName) {
        try {
            log.info("\n[INFO] - Getting a list of marvel characters\n");

            String ts = LocalDateTime.now().toString();
            String limit = marvelProperties.getLimit();
            String privateKey = marvelProperties.getPrivateKey();
            String publicKey = marvelProperties.getPublicKey();
            String hash = DigestUtils.md5DigestAsHex((ts + privateKey + publicKey).getBytes());

            List<MarvelCharacterDomain> marvelCharactersList = Optional.of(marvelApiClient.getCharacterByName(limit, characterName, ts, publicKey, hash))
                    .map(MarvelCharacterDataEntity::getMarvelCharactersResultsEntityList)
                    .map(MarvelCharacterDataEntity.MarvelCharactersResultsEntityList::getMarvelCharacterEntityList)
                    .map(marvelCharacterEntities -> marvelCharacterEntities.stream()
                            .map(marvelUseCaseMapper::toDomain).collect(Collectors.toList()))
                    .orElseThrow(() -> new RestClientException("No results from Marvel API"));

            marvelCharactersList
                    .forEach(character ->
                            character.setImage(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension()));

            return marvelCharactersList;

        } catch (Exception ex) {
            log.error("\n[ERROR] - MARVEL API CLIENT: " + ex.getMessage() + "\n");
            throw new RestClientException("[ERROR] - IMDB API CLIENT: " + ex.getMessage());
        }
    }
}
