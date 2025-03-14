package me.dio.domain.repository;

import me.dio.domain.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    Optional<Agencia> findByNumero(String numero);
}
