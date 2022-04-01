package com.angelozero.daysofcode.entrypoint.mapper;

import com.angelozero.daysofcode.entrypoint.rest.ImdbResponse;
import com.angelozero.daysofcode.usecase.domain.ImdbDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImdbRestMapper {

    ImdbResponse toResponse(final ImdbDomain imdbDomain);
}
