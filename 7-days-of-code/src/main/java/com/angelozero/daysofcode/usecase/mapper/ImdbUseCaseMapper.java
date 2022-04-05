package com.angelozero.daysofcode.usecase.mapper;

import com.angelozero.daysofcode.gateway.entity.MovieEntity;
import com.angelozero.daysofcode.usecase.domain.MovieDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImdbUseCaseMapper {

    MovieDomain toDomain(final MovieEntity movieEntity);
}
