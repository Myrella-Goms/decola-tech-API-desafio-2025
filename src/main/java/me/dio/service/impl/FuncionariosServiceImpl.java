package me.dio.service.impl;

import me.dio.domain.model.Funcionarios;
import me.dio.domain.repository.FuncionariosRepository;
import me.dio.dto.FuncionariosDTO;
import me.dio.service.FuncionariosService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FuncionariosServiceImpl implements FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;

    public FuncionariosServiceImpl(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    @Override
    public FuncionariosDTO findById(Long id) {
        return toDTO(funcionariosRepository.findById(id).
                orElseThrow(NoSuchElementException::new));
    }

    @Override
    public FuncionariosDTO create(FuncionariosDTO funcionariosToCreate) {
        if (funcionariosRepository.existsByCpf(funcionariosToCreate.getCpf())) {
            throw new IllegalArgumentException("Esse cpf já existe.");
        }
        Funcionarios funcionarios = toEntity(funcionariosToCreate);
        funcionariosRepository.save(funcionarios);
        return toDTO(funcionarios);
    }

    @Override
    public FuncionariosDTO update(Long id, FuncionariosDTO funcionariosToUpdate) {
        ;
        Funcionarios funcionarios = funcionariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionarios não encontrado"));
        if (funcionariosToUpdate.getNome() != null) {
            funcionarios.setNome(funcionariosToUpdate.getNome());
        }
        if (funcionariosToUpdate.getTelefone() != null) {
            funcionarios.setTelefone(funcionariosToUpdate.getTelefone());
        }
        if (funcionariosToUpdate.getCargo() != null) {
            funcionarios.setCargo(funcionariosToUpdate.getCargo());
        }
        if (funcionariosToUpdate.getSalario() != null) {
            funcionarios.setSalario(funcionariosToUpdate.getSalario());
        }
        Funcionarios funcionariosAtualizado = funcionariosRepository.save(funcionarios);
        return toDTO(funcionariosAtualizado);
    }

    @Override
    public void delete(Long id) {
        Funcionarios existingFuncionarios = funcionariosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado."));
        funcionariosRepository.delete(existingFuncionarios);
    }

    private FuncionariosDTO toDTO(Funcionarios funcionarios) {
        FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
        funcionariosDTO.setId(funcionarios.getId());
        funcionariosDTO.setNome(funcionarios.getNome());
        funcionariosDTO.setCpf(funcionarios.getCpf());
        funcionariosDTO.setTelefone(funcionarios.getTelefone());
        funcionariosDTO.setAniversario(funcionarios.getAniversario());
        funcionariosDTO.setCargo(funcionarios.getCargo());
        funcionariosDTO.setSalario(funcionarios.getSalario());
        return funcionariosDTO;
    }

    private Funcionarios toEntity(FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionarios = new Funcionarios();
        funcionarios.setNome(funcionariosDTO.getNome());
        funcionarios.setCpf(funcionariosDTO.getCpf());
        funcionarios.setTelefone(funcionariosDTO.getTelefone());
        funcionarios.setAniversario(funcionariosDTO.getAniversario());
        funcionarios.setCargo(funcionariosDTO.getCargo());
        funcionarios.setSalario(funcionariosDTO.getSalario());
        return funcionarios;
    }

}
