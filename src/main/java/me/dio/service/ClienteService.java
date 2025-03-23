package me.dio.service;

import me.dio.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {

    ClienteDTO findById(Long id);
    List<ClienteDTO> findAll();
    ClienteDTO create(ClienteDTO clienteDTO);
    ClienteDTO update(Long id, ClienteDTO clienteDTO);
    void delete(Long id);

}
