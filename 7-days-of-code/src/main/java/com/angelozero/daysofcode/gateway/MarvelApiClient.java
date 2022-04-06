package com.angelozero.daysofcode.gateway;


import com.angelozero.daysofcode.gateway.entity.MarvelCharacterDataEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MarvelApiClient", url = "${marvel.api.url}")
public interface MarvelApiClient {

    @GetMapping("${marvel.api.characters.path}")
    MarvelCharacterDataEntity getCharacterByName(@RequestParam("limit") String limit, @RequestParam("nameStartsWith") String nameStartsWith, @RequestParam("ts") String ts, @RequestParam("apikey") String publicApiKey, @RequestParam("hash") String hash);

}
