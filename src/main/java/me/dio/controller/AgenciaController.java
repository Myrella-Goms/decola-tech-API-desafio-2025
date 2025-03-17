package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.AgenciaDTO;
import me.dio.dto.ClienteDTO;
import me.dio.service.AgenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Agencia")
@RestController
@RequestMapping("/agencia")
public class AgenciaController {

    private final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @GetMapping("/{numero}")
    @Operation(summary = "Encontrar agencia numero")
    public ResponseEntity<AgenciaDTO> findByNumero(@PathVariable String numero) {
        var agencia = agenciaService.findByNumero(numero);
        return ResponseEntity.ok(agencia);
    }

    @PostMapping()
    @Operation(summary = "Criar agencia")
    public ResponseEntity<AgenciaDTO> create(@RequestBody AgenciaDTO agenciaDTO) {
        AgenciaDTO createdAgencia = agenciaService.create(agenciaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agenciaDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAgencia);
    }

    @GetMapping
    @Operation(summary = "Buscar todos as agencias")
    public ResponseEntity<List<AgenciaDTO>> findAll() {
        List<AgenciaDTO> agencia = agenciaService.findAll();
        return ResponseEntity.ok(agencia);
    }

    @PutMapping("/{numero}")
    @Operation(summary = "Atualizar os dados de uma agencia") // Swagger
    public ResponseEntity<AgenciaDTO> updateByNumero(@PathVariable String numero, @RequestBody AgenciaDTO agenciaDTO) {
        AgenciaDTO agenciatoUpdated = agenciaService.updateByNumero(numero, agenciaDTO);
        if (agenciatoUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agenciatoUpdated);
    }

    @DeleteMapping("/{numero}")
    @Operation(summary = "Deletar agencia pelo numero")
    public ResponseEntity<Void> deleteByNumero(@PathVariable String numero)  {
        agenciaService.deleteByNumero(numero);
        return ResponseEntity.noContent().build();
    }
}

