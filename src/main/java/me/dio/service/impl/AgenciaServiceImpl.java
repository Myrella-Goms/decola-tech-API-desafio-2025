package me.dio.service.impl;

import me.dio.domain.model.Agencia;
import me.dio.domain.repository.AgenciaRepository;
import me.dio.dto.AgenciaDTO;
import me.dio.service.AgenciaService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public AgenciaDTO findById(Long id) {
        return toDTO(agenciaRepository.findById(id).
                orElseThrow(NoSuchElementException::new));
    }

    @Override
    public AgenciaDTO create(AgenciaDTO agenciaToCreate) {
        if (agenciaRepository.existsByNumero(agenciaToCreate.getNumero())) {
            throw new IllegalArgumentException("Esse numero já existe.");
        }
        Agencia agencia = toEntity(agenciaToCreate);
        return toDTO(agenciaRepository.save(agencia));
    }

    @Override
    public AgenciaDTO update(Long id, AgenciaDTO agenciaToUpdate) {
        ;
        Agencia agencia = agenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agencia não encontrado"));
        if (agenciaToUpdate.getStatus() != null) {
            agencia.setStatus(agenciaToUpdate.getStatus());
        }
       Agencia agenciaAtualizado = agenciaRepository.save(agencia);
        return toDTO(agenciaAtualizado);
    }

    @Override
    public void delete(Long id) {
        Agencia existingAgencia = agenciaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agencia não encontrada."));
        agenciaRepository.delete(existingAgencia);
    }

    private AgenciaDTO toDTO(Agencia agencia) {
        AgenciaDTO agenciaDTO = new AgenciaDTO();
        agenciaDTO.setId(agencia.getId());
        agenciaDTO.setNumero(agencia.getNumero());
        agenciaDTO.setUnidade(agencia.getUnidade());
        agenciaDTO.setCEP(agencia.getCEP());
        agenciaDTO.setCidade(agencia.getCidade());
        agenciaDTO.setEstado(agencia.getEstado());
        agenciaDTO.setStatus(agencia.getStatus());
        return agenciaDTO;
    }

    private Agencia toEntity(AgenciaDTO agenciaDTO) {
        Agencia agencia = new Agencia();
        agencia.setNumero(agenciaDTO.getNumero());
        agencia.setUnidade(agenciaDTO.getUnidade());
        agencia.setCEP(agenciaDTO.getCEP());
        agencia.setCidade(agenciaDTO.getCidade());
        agencia.setEstado(agenciaDTO.getEstado());
        agencia.setStatus(agenciaDTO.getStatus());
        return agencia;
    }

}
