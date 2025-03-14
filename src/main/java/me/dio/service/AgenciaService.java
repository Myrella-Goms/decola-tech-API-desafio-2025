package me.dio.service;

import me.dio.dto.AgenciaDTO;

public interface AgenciaService {

    AgenciaDTO findByNumero(String numero);

    AgenciaDTO create(AgenciaDTO agenciaDTO);

    AgenciaDTO update(Long id, AgenciaDTO agenciaToUpdate);

    void delete(Long id);

}
