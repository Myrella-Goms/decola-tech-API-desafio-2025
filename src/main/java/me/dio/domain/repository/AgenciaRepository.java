package me.dio.domain.repository;

import me.dio.domain.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    boolean existsByNumero(String numero);
}
