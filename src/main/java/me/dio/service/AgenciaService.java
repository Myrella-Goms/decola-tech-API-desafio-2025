package me.dio.service;

import me.dio.dto.AgenciaDTO;

public interface AgenciaService {

    AgenciaDTO findById(Long id);

    AgenciaDTO create(AgenciaDTO agenciaToCreate);

    AgenciaDTO update(Long id, AgenciaDTO agenciaToUpdate);

    void delete(Long id);

}
