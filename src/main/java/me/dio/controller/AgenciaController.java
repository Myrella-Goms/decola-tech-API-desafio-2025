package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.AgenciaDTO;
import me.dio.service.AgenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Agencia")
@RestController
@RequestMapping("/agencia")
public class AgenciaController {

    private final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar agencia ID")
    public ResponseEntity<AgenciaDTO> findById(@PathVariable Long id) {
        var cliente = agenciaService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    @Operation(summary = "Criar agencia")
    public ResponseEntity<AgenciaDTO> create(@RequestBody AgenciaDTO agenciaToCreate) {
        AgenciaDTO createdAgencia = agenciaService.create(agenciaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agenciaToCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAgencia);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar os dados de uma agencia") // Swagger
    public ResponseEntity<AgenciaDTO> update(@PathVariable Long id, @RequestBody AgenciaDTO agenciaToUpdate) {
        AgenciaDTO agenciatoUpdated = agenciaService.update(id, agenciaToUpdate);
        if (agenciatoUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agenciaToUpdate);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar agencia pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

