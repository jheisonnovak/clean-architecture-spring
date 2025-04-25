package com.jheisonnovak.clean_architecture_spring.shared.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
