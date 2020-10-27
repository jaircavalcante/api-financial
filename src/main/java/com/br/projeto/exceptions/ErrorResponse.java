package com.br.projeto.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {

    private final String message;
    
    private final LocalDateTime date;
    
    private final Throwable cause;
    
    public ErrorResponse(String message, LocalDateTime date, Throwable causeException) {
        super();
        this.message = message;
        this.date = date;
        this.cause = causeException;
    }
    
}