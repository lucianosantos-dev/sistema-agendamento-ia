package com.lucianodev.sistemaagendamentoia.mapper;

import com.lucianodev.sistemaagendamentoia.dto.request.ServicoCreateDto;
import com.lucianodev.sistemaagendamentoia.dto.request.ServicoUpdateDto;
import com.lucianodev.sistemaagendamentoia.dto.response.ServicoResponse;
import com.lucianodev.sistemaagendamentoia.entity.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ServicoMapper {

    ServicoResponse toResponse(Servico entity);
    Servico toEntity(ServicoCreateDto servicoCreateDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ServicoUpdateDto updateDto, @MappingTarget Servico servico);
}
