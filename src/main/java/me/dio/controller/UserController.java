package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import me.dio.dto.AccountDTO;
import me.dio.dto.UserDTO;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar usúario pelo ID")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    @Operation (summary = "Adicionar usuário")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userToCreate) {
        if (userToCreate.getAccount() == null) {
            userToCreate.setAccount(new AccountDTO());
        }
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados pelo ID")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userToUpdate) {
        var updatedUser = userService.update(id, userToUpdate);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usúario pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}