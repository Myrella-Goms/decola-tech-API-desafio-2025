package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.domain.model.Cliente;
import me.dio.domain.repository.ClienteRepository;
import me.dio.dto.ClienteDTO;
import me.dio.mapper.ClienteMapper;
import me.dio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Autowired
    private AgenciaRepository agenciaRepository;
    @Autowired
    private ClienteMapper clienteMapper;;

    @Override
    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new IllegalArgumentException("Esse CPF já existe.");
        }

        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Agencia agencia = agenciaRepository.findById(clienteDTO.getAgencia_id())
                .orElseThrow(() -> new IllegalArgumentException("Agência não encontrada"));
        cliente.setAgencia(agencia);

        Cliente createdcliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(createdcliente);
    }


    @Override
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
    Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

    if (clienteDTO.getNome() != null) {
        cliente.setNome(clienteDTO.getNome());
    }
    if (clienteDTO.getEmail() != null) {
        cliente.setEmail(clienteDTO.getEmail());
    }
    if (clienteDTO.getTelefone() != null) {
        cliente.setTelefone(clienteDTO.getTelefone());
    }

    Cliente clienteAtualizado = clienteRepository.save(cliente);
    return clienteMapper.toDTO(clienteAtualizado);
    }


    @Override
    public void delete(Long id) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Id não existe"));
        clienteRepository.delete(existingCliente);
    }

}
