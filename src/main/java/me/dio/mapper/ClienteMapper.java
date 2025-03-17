package me.dio.mapper;

import me.dio.domain.model.Cliente;
import me.dio.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "agencia.id", target = "agencia_id")
    ClienteDTO toDTO(Cliente cliente);
    @Mapping(source = "agencia_id", target = "agencia.id")
    Cliente toEntity(ClienteDTO clienteDTO);

}
