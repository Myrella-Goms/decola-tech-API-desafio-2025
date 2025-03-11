package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.FuncionariosDTO;
import me.dio.service.FuncionariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Funcionarios")
@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    private final FuncionariosService funcionariosService;

    public FuncionariosController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar funcionarios pelo ID")
    public ResponseEntity<FuncionariosDTO> findById(@PathVariable Long id) {
        var funcionarios = funcionariosService.findById(id);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping()
    @Operation(summary = "Adicionar funcionarios")
    public ResponseEntity<FuncionariosDTO> create(@RequestBody FuncionariosDTO funcionariosToCreate) {
        FuncionariosDTO createdFuncionarios = funcionariosService.create(funcionariosToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionariosToCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdFuncionarios);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar os dados de um funcionario") // Swagger
    public ResponseEntity<FuncionariosDTO> update(@PathVariable Long id, @RequestBody FuncionariosDTO funcionariosToUpdate) {
        FuncionariosDTO funcionariosUpdated = funcionariosService.update(id, funcionariosToUpdate);
        if (funcionariosUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionariosUpdated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar funcionario pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionariosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

