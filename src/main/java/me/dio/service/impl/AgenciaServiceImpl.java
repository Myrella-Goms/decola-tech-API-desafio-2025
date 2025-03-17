package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.dto.AgenciaDTO;
import me.dio.mapper.AgenciaMapper;
import me.dio.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }
    @Autowired
    private AgenciaMapper agenciaMapper;

    @Override
    public AgenciaDTO findByNumero(String numero)  {
        Agencia agencia = agenciaRepository.findByNumero(numero)
                .orElseThrow(() -> new NoSuchElementException("Agencia não encontrada"));
        return agenciaMapper.toDTO(agencia);
    }

    @Override
    public List<AgenciaDTO> findAll() {
        return agenciaRepository.findAll().stream()
                .map(agenciaMapper::toDTO)
                .toList();
    }

    @Override
    public AgenciaDTO create(AgenciaDTO agenciaDTO) {
        if (agenciaRepository.findByNumero(agenciaDTO.getNumero()).isPresent()) {
            throw new IllegalArgumentException("Esse número já existe.");
        }
        Agencia createAgencia = agenciaMapper.toEntity(agenciaDTO);
        return agenciaMapper.toDTO(agenciaRepository.save(createAgencia));
    }

    @Override
    public AgenciaDTO updateByNumero(String numero, AgenciaDTO agenciaDTO) {
        Agencia agencia = agenciaRepository.findByNumero(numero)
                .orElseThrow(() -> new NoSuchElementException("Agencia não encontrada"));
        if (agenciaDTO.getStatus() != null) {
            agencia.setStatus(agenciaDTO.getStatus());
        }
       Agencia agenciacreated = agenciaRepository.save(agencia);
        return agenciaMapper.toDTO(agenciacreated);
    }

    @Override
    public void deleteByNumero(String numero) {
        Agencia existingAgencia = agenciaRepository.findByNumero(numero)
                .orElseThrow(() -> new NoSuchElementException("Agencia não encontrada."));
        agenciaRepository.delete(existingAgencia);
    }
}
