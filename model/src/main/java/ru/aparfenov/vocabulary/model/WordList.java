package ru.aparfenov.vocabulary.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Builder
@Accessors
public class WordList {
    /**key - word UID, assigned while adding the new word into storage*/
    private Map<String, Word> wordList;
}
