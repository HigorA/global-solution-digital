package br.com.fiap.exceptions;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ExceptionDTO> NotFoundException(ChangeSetPersister.NotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDTO(HttpStatus.NOT_FOUND, e.getMessage())
        );
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<ExceptionDTO> ForbiddenException(HttpClientErrorException.Forbidden e){

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ExceptionDTO(HttpStatus.FORBIDDEN, e.getMessage())
        );
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ExceptionDTO> BadRequestException(HttpClientErrorException.BadRequest e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDTO> IllegalArgumentException(IllegalArgumentException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage().toString())
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> HttpMessageNotReadableException(HttpMessageNotReadableException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> DataIntegrityViolationException(DataIntegrityViolationException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionDTO> UsernameNotFoundException(UsernameNotFoundException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage())
        );
    }

}
