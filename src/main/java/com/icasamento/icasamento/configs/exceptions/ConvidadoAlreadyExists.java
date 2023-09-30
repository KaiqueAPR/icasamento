package com.icasamento.icasamento.configs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConvidadoAlreadyExists extends RuntimeException {
    public ConvidadoAlreadyExists(String message) {
        super(message);
    }

    public ConvidadoAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

}
