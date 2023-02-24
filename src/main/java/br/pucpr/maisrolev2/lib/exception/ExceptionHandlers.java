package br.pucpr.maisrolev2.lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlers {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        var error = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(v -> String.format("'%s' %s",
                        ((FieldError)v).getField(),
                        v.getDefaultMessage())
                ).collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(error);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Resource not found",
                details
        );

        return ResponseEntityBuilder.build(error);
    }
}
