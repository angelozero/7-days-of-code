package com.angelozero.daysofcode.entrypoint.mapper;

import com.angelozero.daysofcode.entrypoint.rest.MarvelCharacterResponse;
import com.angelozero.daysofcode.usecase.domain.MarvelCharacterDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarvelRestMapper {

    MarvelCharacterResponse toResponse(final MarvelCharacterDomain marvelCharacterDomain);
}
