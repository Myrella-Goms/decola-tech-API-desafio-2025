package me.dio.service;

import me.dio.dto.FuncionariosDTO;
import java.util.List;

public interface FuncionariosService {

    FuncionariosDTO findById(Long id);
    List<FuncionariosDTO> findAll();
    FuncionariosDTO create(FuncionariosDTO funcionariosDTO);
    FuncionariosDTO update(Long id, FuncionariosDTO funcionariosDTO);
    void delete(Long id);

}
