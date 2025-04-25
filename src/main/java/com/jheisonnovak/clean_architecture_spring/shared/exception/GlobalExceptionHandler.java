package com.jheisonnovak.clean_architecture_spring.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
            .stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .findFirst()
            .orElse("Invalid input");

        return new ResponseEntity<>(
            new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", message),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", "Request body is missing or invalid"),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiError> handleBusiness(BusinessException ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", "Something went wrong"),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiError> handleIllegalState(IllegalStateException ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Unprocessable Entity", ex.getMessage()),
            HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleResponseStatus(NotFoundException ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiError> handleNoResourceFound(NoResourceFoundException ex) {
        return new ResponseEntity<>(
            new ApiError(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }
}
