package me.dio.service;

import me.dio.dto.FuncionariosDTO;

public interface FuncionariosService {

    FuncionariosDTO findById(Long id);

    FuncionariosDTO create(FuncionariosDTO funcionariosToCreate);

    FuncionariosDTO update(Long id, FuncionariosDTO funcionariosToUpdate);

    void delete(Long id);

}
