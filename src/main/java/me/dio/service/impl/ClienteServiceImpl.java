package me.dio.service.impl;

import me.dio.domain.model.Cliente;
import me.dio.domain.repository.ClienteRepository;
import me.dio.dto.ClienteDTO;
import me.dio.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO findById(Long id) {
        return toDTO(clienteRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteToCreate) {
        if (clienteRepository.existsByCpf(clienteToCreate.getCpf())) {
            throw new IllegalArgumentException("Esse cpf já existe.");
        }
        Cliente cliente = toEntity(clienteToCreate);
        return toDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO clienteToUpdate) {
        ;
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
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
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        clienteRepository.delete(existingCliente);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }

    private Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

}
