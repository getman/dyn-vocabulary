package ru.aparfenov.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aparfenov.app.service.WordService;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Slf4j
@RestController
public class TranslateController {
    @Autowired
    private WordService wordService;

    @GetMapping("/translate")
    public ResponseEntity<String> translate() {
        if (log.isTraceEnabled()) {
            log.trace("/translate start");
        }
        System.out.println("/translate ");
        if (log.isTraceEnabled()) {
            log.trace("/translate end");
        }
        return new ResponseEntity<>(wordService.traslate(), HttpStatus.OK);
    }

    public void updateTranslation() {

    }

    public void updateWord() {

    }

    public void addNewWord() {

    }

    public void putWordIntoProblem() {

    }

}

