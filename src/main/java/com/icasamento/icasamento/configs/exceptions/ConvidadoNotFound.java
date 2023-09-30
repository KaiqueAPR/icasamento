package com.icasamento.icasamento.configs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConvidadoNotFound extends RuntimeException {

    public ConvidadoNotFound(String message) {
        super(message);
    }

    public ConvidadoNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
