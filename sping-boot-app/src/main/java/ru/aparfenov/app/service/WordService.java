package ru.aparfenov.app.service;

import org.springframework.stereotype.Component;
import ru.aparfenov.vocabulary.model.dto.CommonWordsDto;
import ru.aparfenov.vocabulary.model.dto.ProblemWordsDto;
import ru.aparfenov.vocabulary.model.dto.WordDto;

import java.util.ArrayList;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Component
public class WordService {
    public CommonWordsDto getCommonWords() {
        return CommonWordsDto.builder().build();
    }

    public ProblemWordsDto getProblemWords() {
        return ProblemWordsDto.builder()
                .problemWords(new ArrayList<WordDto>(){{
                    add(WordDto.builder().wordEn("we").build());
                    add(WordDto.builder().wordEn("er").build());
                    add(WordDto.builder().wordEn("rt").build());
                }})
                .build();
    }

    public String traslate(WordDto wordDto) {
        return "Hello World!";
    }

    /**updates the specified word
     * @param wordToUpdate word to update*/
    public void updateWord(WordDto wordToUpdate) {

    }

    /**adds new word into the storage
     * @param newWord new word to add into the storage*/
    public void addNewWord(WordDto newWord) {

    }

    /**adds word to problem words set
     * @param wordUid UID of the specified word*/
    public void addWordToProblem(String wordUid) {

    }
}
