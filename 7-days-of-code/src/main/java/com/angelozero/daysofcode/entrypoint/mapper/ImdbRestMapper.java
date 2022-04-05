package com.angelozero.daysofcode.entrypoint.mapper;

import com.angelozero.daysofcode.entrypoint.rest.MovieResponse;
import com.angelozero.daysofcode.usecase.domain.MovieDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImdbRestMapper {

    MovieResponse toResponse(final MovieDomain movieDomain);
}
