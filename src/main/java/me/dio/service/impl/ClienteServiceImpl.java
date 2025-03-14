package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.domain.model.Cliente;
import me.dio.domain.repository.ClienteRepository;
import me.dio.dto.ClienteDTO;
import me.dio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final AgenciaRepository agenciaRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, AgenciaRepository agenciaRepository) {
        this.clienteRepository = clienteRepository;
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public ClienteDTO findById(Long id) {
        return toDTO(clienteRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Id não existe")));
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            throw new IllegalArgumentException("Esse cpf já existe.");
        }
        Cliente createcliente = toEntity(clienteDTO);
        return toDTO(clienteRepository.save(createcliente));
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO clienteToUpdate) {
        ;
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        if (clienteToUpdate.getNome() != null) {
            cliente.setNome(clienteToUpdate.getNome());
        }
        if (clienteToUpdate.getEmail() != null) {
            cliente.setEmail(clienteToUpdate.getEmail());
        }
        if (clienteToUpdate.getTelefone() != null) {
            cliente.setTelefone(clienteToUpdate.getTelefone());
        }
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        return toDTO(clienteAtualizado);
    }

    @Override
    public void delete(Long id) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Id não existe"));
        clienteRepository.delete(existingCliente);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setAgencia_id(cliente.getAgencia().getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }

    private Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        Agencia agencia = agenciaRepository.findById(clienteDTO.getAgencia_id())
                .orElseThrow(() -> new NoSuchElementException("Agência não encontrada"));
        cliente.setAgencia(agencia);
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

}
