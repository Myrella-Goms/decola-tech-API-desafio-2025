package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.dto.AgenciaDTO;
import me.dio.exception.AgenciaNotFoundException;
import me.dio.mapper.AgenciaMapper;
import me.dio.service.AgenciaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;
    private final AgenciaMapper agenciaMapper;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository, AgenciaMapper agenciaMapper) {
        this.agenciaRepository = agenciaRepository;
        this.agenciaMapper = agenciaMapper;
    }

    @Override
    public AgenciaDTO findByNumero(String numero)  {
        Agencia agencia = agenciaRepository.findByNumero(numero)
                .orElseThrow(() -> new AgenciaNotFoundException("Agencia não encontrada"));
        return agenciaMapper.toDTO(agencia);
    }

    @Override
    public List<AgenciaDTO> findAll() {
        return agenciaRepository.findAll().stream() // converte a lista de objetos em um fluxo que permite fazer operações funcionais sobre os elementos da lista, como mapear, filtrar ou reduzir.
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
                .orElseThrow(() -> new AgenciaNotFoundException("Agencia não encontrada"));
        if (agenciaDTO.getStatus() != null) {
            agencia.setStatus(agenciaDTO.getStatus());
        }
        if (agenciaDTO.getCEP() != null) {
            agencia.setCEP(agenciaDTO.getCEP());
        }
       Agencia agenciaCreated = agenciaRepository.save(agencia);
        return agenciaMapper.toDTO(agenciaCreated);
    }

    @Override
    public void deleteByNumero(String numero) {
        Agencia existingAgencia = agenciaRepository.findByNumero(numero)
                .orElseThrow(() -> new AgenciaNotFoundException("Agencia não encontrada"));
        agenciaRepository.delete(existingAgencia);
    }
}
