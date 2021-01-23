package com.sda.ultraguitartron.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice //@ControllerAdvice + @ResponseBody
public class ExceptionHandlerController {

//    @ExceptionHandler(ChordNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorMessage chordNotFoundExceptionHandler(ChordNotFoundException exception) {
//        log.debug(exception.getMessage());
//        return new ErrorMessage(exception.getMessage());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        Map<String, List<String>> fieldNamesToErrorMessages = new HashMap<>();
        for (FieldError fieldError :
                exception.getFieldErrors()) {
            String fieldName = fieldError.getField();
            if (fieldNamesToErrorMessages.containsKey(fieldName)) {
                fieldNamesToErrorMessages.get(fieldName).add(fieldError.getDefaultMessage());
            } else {
                List<String> errorList = new ArrayList<>();
                errorList.add(fieldError.getDefaultMessage());
                fieldNamesToErrorMessages.put(fieldName, errorList);
            }
        }
        return new ErrorMessage(fieldNamesToErrorMessages);
    }
//
//    @ExceptionHandler(NoSuchElementException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorMessage handleNoSuchElementException(NoSuchElementException exception) {
//        Map<String, List<String>> fieldNamesToErrorMessages = new HashMap<>();
//        for (FieldError fieldError :
//                exception.getFieldErrors()) {
//            String fieldName = fieldError.getField();
//            if (fieldNamesToErrorMessages.containsKey(fieldName)) {
//                fieldNamesToErrorMessages.get(fieldName).add(fieldError.getDefaultMessage());
//            } else {
//                List<String> errorList = new ArrayList<>();
//                errorList.add(fieldError.getDefaultMessage());
//                fieldNamesToErrorMessages.put(fieldName, errorList);
//            }
//        }
//        return new ErrorMessage(fieldNamesToErrorMessages);
//    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    void scaleNotFoundException(ScaleNotFoundException exception) {
//        log.error(exception.getMessage());
//    }
//
//    @ExceptionHandler(TraineeNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    void traineeNotFoundException(TraineeNotFoundException exception) {
//        log.error(exception.getMessage());
//    }
//
    @ExceptionHandler(InvalidNoteInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void invalidNoteInputException(InvalidNoteInputException exception) {
        log.debug(exception.getMessage());
    }

    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void noteNotFoundException(NoteNotFoundException exception){
        log.debug(exception.getMessage());
    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    void invalidNameException(InvalidNameException exception) {
//        log.error(exception.getMessage());
//    }
}