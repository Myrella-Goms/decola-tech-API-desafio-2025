package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.ClienteDTO;
import me.dio.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar clientes pelo ID")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    @Operation(summary = "Adicionar cliente")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdCliente = clienteService.create(clienteDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar os dados de um cliente") // Swagger
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteToUpdate) {
        ClienteDTO clienteUpdated = clienteService.update(id, clienteToUpdate);
        if (clienteUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteUpdated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

