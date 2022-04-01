package com.angelozero.daysofcode.gateway;


import com.angelozero.daysofcode.gateway.entity.ImdbListEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ImdbApiClient", url = "${imdbApiClient.api.url}")
public interface ImdbApiClient {

    @GetMapping("${imdbApiClient.api.path}")
    ImdbListEntity getTop250Movies(@PathVariable("apiKey") String apiKey);

}
