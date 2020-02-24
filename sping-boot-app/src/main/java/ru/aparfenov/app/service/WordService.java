package ru.aparfenov.app.service;

import org.springframework.stereotype.Component;
import ru.aparfenov.app.exception.StorageConnectionException;
import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.dto.WordDto;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Component
public class WordService {
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
