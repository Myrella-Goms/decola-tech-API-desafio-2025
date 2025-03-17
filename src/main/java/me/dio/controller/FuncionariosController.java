package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.FuncionariosDTO;
import me.dio.service.FuncionariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

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
    
    @GetMapping
    @Operation(summary = "Buscar todos os funcionarios")
    public ResponseEntity<List<FuncionariosDTO>> findAll() {
        List<FuncionariosDTO> funcionarios = funcionariosService.findAll();
        return ResponseEntity.ok(funcionarios);
    }


    @PostMapping()
    @Operation(summary = "Adicionar funcionarios")
    public ResponseEntity<FuncionariosDTO> create(@RequestBody FuncionariosDTO funcionariosDTO) {
        FuncionariosDTO createdFuncionarios = funcionariosService.create(funcionariosDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionariosDTO.getId())
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

