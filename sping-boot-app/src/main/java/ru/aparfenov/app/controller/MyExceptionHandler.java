package ru.aparfenov.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.aparfenov.app.exception.StorageConnectionException;
import ru.aparfenov.app.exception.StorageInternalException;
import ru.aparfenov.app.exception.UnknownWordException;

/**
 * Created by ArtemParfenov on 05.02.2020.
 */

@Slf4j
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> commonException(RuntimeException ex, WebRequest request) {
        log.error("Undefined error", ex);
        String bodyOfResponse = "Something went wrong, sory for that";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(StorageConnectionException.class)
    protected ResponseEntity<Object> storageConnectionException(StorageConnectionException ex, WebRequest request) {
        log.error("StorageConnectionException", ex);
        String bodyOfResponse = "Storage connection error";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(StorageInternalException.class)
    protected ResponseEntity<Object> storageInternalException(StorageInternalException ex, WebRequest request) {
        log.error("StorageInternalException", ex);
        String bodyOfResponse = "Error inside the storage occured";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(UnknownWordException.class)
    protected ResponseEntity<Object> unknownWordException(UnknownWordException ex, WebRequest request) {
        log.error("UnknownWordException", ex);
        String bodyOfResponse = "Couldn`t find a word";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}