package ru.aparfenov.app.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aparfenov.vocabulary.model.Converters;
import ru.aparfenov.vocabulary.model.dto.CommonWordsDto;
import ru.aparfenov.vocabulary.model.dto.ProblemWordsDto;
import ru.aparfenov.vocabulary.model.dto.WordDto;
import ru.aparfenov.vocabulary.storage.WordStorageDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Component
public class WordService {
    @Autowired
    private WordStorageDao wordStorageDao;
    public CommonWordsDto getCommonWords() {
        return CommonWordsDto.builder()
                .commonWords(Optional.ofNullable(wordStorageDao.getGeneralWords())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(Converters::fromWord)
                        .collect(Collectors.toList()))
                .build();
    }

    public ProblemWordsDto getProblemWords() {
        return ProblemWordsDto.builder()
                .problemWords(Optional.ofNullable(wordStorageDao.getProblemWords())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(Converters::fromWord)
                        .collect(Collectors.toList()))
                .build();
    }

    public String traslate(WordDto wordDto) {
        return "Hello World!";
    }

    /**updates the specified word
     * @param wordToUpdate word to update*/
    @SneakyThrows
    public void updateWord(WordDto wordToUpdate) {
        wordStorageDao.updateWord(Converters.fromWordDto(wordToUpdate));
    }

    /**adds new word into the storage
     * @param newWord new word to add into the storage*/
    public void addNewWord(WordDto newWord) {
        wordStorageDao.addWord(Converters.fromWordDto(newWord));
    }

    /**adds word to problem words set
     * @param wordUid UID of the specified word*/
    public void addWordToProblem(String wordUid) {
        wordStorageDao.addWordToProblem(wordUid);
    }
}
