package me.dio.mapper;

import me.dio.domain.model.Funcionarios;
import me.dio.dto.FuncionariosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FuncionariosMapper {

    @Mapping(source = "agencia.id", target = "agencia_id")
    FuncionariosDTO toDTO(Funcionarios funcionarios);
    @Mapping(source = "agencia_id", target = "agencia.id")
    Funcionarios toEntity(FuncionariosDTO funcionariosDTO);
}
