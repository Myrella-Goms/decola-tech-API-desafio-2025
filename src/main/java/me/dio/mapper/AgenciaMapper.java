package me.dio.mapper;

import me.dio.domain.model.Agencia;
import me.dio.dto.AgenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgenciaMapper {
    AgenciaDTO toDTO(Agencia agencia);
    Agencia toEntity(AgenciaDTO agenciaDTO);
}
