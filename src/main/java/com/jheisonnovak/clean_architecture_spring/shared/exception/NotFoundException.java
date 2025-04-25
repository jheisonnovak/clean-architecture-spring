package com.jheisonnovak.clean_architecture_spring.shared.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }    
}
