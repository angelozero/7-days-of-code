package com.angelozero.daysofcode.usecase.mapper;

import com.angelozero.daysofcode.gateway.entity.MarvelCharacterEntity;
import com.angelozero.daysofcode.usecase.domain.MarvelCharacterDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarvelUseCaseMapper {

    MarvelCharacterDomain toDomain(final MarvelCharacterEntity marvelCharacterEntity);
}
