package me.dio.repository;

import me.dio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Jparepository é uma interface fornecida pelo SDJPA que estendemos para as entidades
// e possui métodos prontos para as operações de CRUD

public interface UserRepository extends JpaRepository <User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}


