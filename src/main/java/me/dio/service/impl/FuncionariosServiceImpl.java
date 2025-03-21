package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.model.Funcionarios;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.domain.repository.FuncionariosRepository;
import me.dio.dto.FuncionariosDTO;
import me.dio.mapper.FuncionariosMapper;
import me.dio.service.FuncionariosService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FuncionariosServiceImpl implements FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;
    private final AgenciaRepository agenciaRepository;
    private final FuncionariosMapper funcionariosMapper;

    public FuncionariosServiceImpl(FuncionariosRepository funcionariosRepository, AgenciaRepository agenciaRepository, FuncionariosMapper funcionariosMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.agenciaRepository = agenciaRepository;
        this.funcionariosMapper = funcionariosMapper;
    }

    @Override
    public FuncionariosDTO findById(Long id) {
        Funcionarios funcionarios = funcionariosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado"));
        return funcionariosMapper.toDTO(funcionarios);
    }

    @Override
    public List<FuncionariosDTO> findAll() {
        return funcionariosRepository.findAll().stream()
                .map(funcionariosMapper::toDTO)
                .toList();
    }

    @Override
    public FuncionariosDTO create(FuncionariosDTO funcionariosDTO) {
        if (funcionariosRepository.existsByCpf(funcionariosDTO.getCpf())) {
            throw new IllegalArgumentException("Esse CPF já existe.");
        }
        Funcionarios funcionarios = funcionariosMapper.toEntity(funcionariosDTO);
        Agencia agencia = agenciaRepository.findById(funcionariosDTO.getAgencia_id())
                .orElseThrow(() -> new IllegalArgumentException("Agência não encontrada"));
        funcionarios.setAgencia(agencia);

        Funcionarios createdfuncionarios = funcionariosRepository.save(funcionarios);
        return funcionariosMapper.toDTO(createdfuncionarios);
    }

    @Override
    public FuncionariosDTO update(Long id, FuncionariosDTO funcionariosDTO) {

        Funcionarios funcionarios = funcionariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionarios não encontrado"));
        if (funcionariosDTO.getNome() != null) {
            funcionarios.setNome(funcionariosDTO.getNome());
        }
        if (funcionariosDTO.getTelefone() != null) {
            funcionarios.setTelefone(funcionariosDTO.getTelefone());
        }
        if (funcionariosDTO.getCargo() != null) {
            funcionarios.setCargo(funcionariosDTO.getCargo());
        }
        if (funcionariosDTO.getSalario() != null) {
            funcionarios.setSalario(funcionariosDTO.getSalario());
        }
        Funcionarios funcionariosAtualizado = funcionariosRepository.save(funcionarios);
        return  funcionariosMapper.toDTO(funcionariosAtualizado);
    }

    @Override
    public void delete(Long id) {
        Funcionarios existingFuncionarios = funcionariosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado."));
        funcionariosRepository.delete(existingFuncionarios);
    }


}
