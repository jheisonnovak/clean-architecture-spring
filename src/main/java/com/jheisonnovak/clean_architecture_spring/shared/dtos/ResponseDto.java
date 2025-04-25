package com.jheisonnovak.clean_architecture_spring.shared.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message) {
        this.message = message;
        this.data = null;
    }

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
