package ru.aparfenov.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aparfenov.app.service.WordService;
import ru.aparfenov.vocabulary.model.dto.WordDto;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Slf4j
@RestController
public class TranslateController {
    @Autowired
    private WordService wordService;

    @GetMapping("/translate")
    public ResponseEntity<String> translate(@RequestBody WordDto wordToTranslateDto) {
        if (log.isTraceEnabled()) {
            log.trace("/translate start");
        }
        if (log.isTraceEnabled()) {
            log.trace("/translate end");
        }
        return new ResponseEntity<String>(wordService.traslate(wordToTranslateDto), HttpStatus.OK);
    }

    @PostMapping("/update-word")
    public ResponseEntity updateWord(@RequestBody WordDto wordToUpdateDto) {
        if (log.isTraceEnabled()) {
            log.trace("/update-word start");
        }
        if (log.isTraceEnabled()) {
            log.trace("/update-word end");
        }
        wordService.updateWord(wordToUpdateDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/add-new-word")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addNewWord(@RequestBody WordDto newWordDto) {
        if (log.isTraceEnabled()) {
            log.trace("/add-new-word start");
        }
        if (log.isTraceEnabled()) {
            log.trace("/add-new-word end");
        }
        wordService.addNewWord(newWordDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-word-to-problem")
    public ResponseEntity putWordIntoProblem(@RequestBody WordDto problemWord) {
        if (log.isTraceEnabled()) {
            log.trace("/add-word-to-problem start");
        }
        if (log.isTraceEnabled()) {
            log.trace("/add-word-to-problem end");
        }
        wordService.addWordToProblem(problemWord.getUid());
        return ResponseEntity.ok().build();
    }

}

