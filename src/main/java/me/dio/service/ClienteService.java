package me.dio.service;

import me.dio.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO findById(Long id);

    ClienteDTO create(ClienteDTO clienteDTO);

    ClienteDTO update(Long id, ClienteDTO clienteDTO);

    void delete(Long id);

}
