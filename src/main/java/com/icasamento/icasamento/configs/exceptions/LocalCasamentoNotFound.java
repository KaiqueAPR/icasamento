package com.icasamento.icasamento.configs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocalCasamentoNotFound extends RuntimeException {

    public LocalCasamentoNotFound(String message) {
        super(message);
    }

    public LocalCasamentoNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
