package ru.aparfenov.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get")
    public void translate() {
        log.debug("/translate was called");
        System.out.println("/translate ");
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

