package me.dio.domain.repository;

import me.dio.domain.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

    boolean existsByCpf(String cpf);
}
