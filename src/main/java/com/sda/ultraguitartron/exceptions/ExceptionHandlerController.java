package com.sda.ultraguitartron.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice //@ControllerAdvice + @ResponseBody
public class ExceptionHandlerController {

    @ExceptionHandler(ChordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage chordNotFoundExceptionHandler(ChordNotFoundException exception) {
        log.debug(exception.getMessage());
        return new ErrorMessage(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void scaleNotFoundException(ScaleNotFoundException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(TraineeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void traineeNotFoundException(TraineeNotFoundException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void invalidNoteInputException(InvalidNoteInputException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void invalidNameException(InvalidNameException exception) {
        log.error(exception.getMessage());
    }
}
