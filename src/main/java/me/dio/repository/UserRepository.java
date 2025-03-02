package me.dio.repository;

import me.dio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}


