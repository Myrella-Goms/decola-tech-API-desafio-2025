package me.dio.exception;

public class AgenciaNotFoundException extends RuntimeException {
    public AgenciaNotFoundException(String message) {
        super(message);
    }
}
