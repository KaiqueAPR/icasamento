package com.icasamento.icasamento.configs;

import com.icasamento.icasamento.configs.exceptions.ConvidadoAlreadyExists;
import com.icasamento.icasamento.configs.exceptions.ConvidadoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handleValidationErrors(MethodArgumentNotValidException e) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setType(e.getBody().getType());
        problemDetail.setTitle("Dado não informado corretamente");
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        String detail = String.join(", ", MethodArgumentNotValidException.errorsToStringList(errors));
        problemDetail.setDetail(detail);
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    ProblemDetail handleGeneralExceptions(Exception e) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        problemDetail.setTitle("Erro interno do servidor");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(RuntimeException.class)
    ProblemDetail handleRuntimeExceptions(RuntimeException e) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        problemDetail.setTitle("Erro interno do servidor");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(ConvidadoNotFound.class)
    ProblemDetail handleConvidadoNotFoundException(ConvidadoNotFound e) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("Convidado não encontrado");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(ConvidadoAlreadyExists.class)
    ProblemDetail handleConvidadoAlreadyExistsException(ConvidadoAlreadyExists e) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        problemDetail.setTitle("Convidado já existe");
        problemDetail.setDetail(e.getMessage());
        return problemDetail;
    }
}
