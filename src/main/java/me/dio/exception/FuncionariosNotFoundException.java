package me.dio.exception;

public class FuncionariosNotFoundException extends RuntimeException {
    public FuncionariosNotFoundException(String message) {
        super(message);
    }
}