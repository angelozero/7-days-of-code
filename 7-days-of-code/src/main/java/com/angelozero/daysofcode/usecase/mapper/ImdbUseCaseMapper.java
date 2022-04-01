package com.angelozero.daysofcode.usecase.mapper;

import com.angelozero.daysofcode.gateway.entity.ImdbEntity;
import com.angelozero.daysofcode.usecase.domain.ImdbDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImdbUseCaseMapper {

    ImdbDomain toDomain(final ImdbEntity imdbEntity);
}
