package me.dio.service;

import me.dio.dto.AgenciaDTO;
import me.dio.dto.ClienteDTO;

import java.util.List;

public interface AgenciaService {

    AgenciaDTO findByNumero(String numero);
    List<AgenciaDTO> findAll();
    AgenciaDTO create(AgenciaDTO agenciaDTO);
    AgenciaDTO updateByNumero(String numero, AgenciaDTO agenciaDTO);
    void deleteByNumero(String numero);

}
