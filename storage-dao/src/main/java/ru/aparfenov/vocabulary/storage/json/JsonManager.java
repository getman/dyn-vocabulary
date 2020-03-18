package ru.aparfenov.vocabulary.storage.json;

import ru.aparfenov.dynvocabulary.util.JsonUtils;
import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.WordList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class JsonManager {
    public static List<Word> getCommonWords() {
        return getWords(JsonUtils.STORAGE_COMMON_WORDS);
    }

    public static List<Word> getProblemWords() {
        return getWords(JsonUtils.STORAGE_PROBLEM_WORDS);
    }

    /**adds some new word to the storage into common word list*/
    public static void addWord(Word newWord) {
        Map<String, Word> commonWords = Optional.ofNullable(JsonUtils.loadFromJson(WordList.class, JsonUtils.STORAGE_COMMON_WORDS))
                .map(WordList::getWordList)
                .orElse(Collections.emptyMap());
        commonWords.put(newWord.getUid(), newWord);
        JsonUtils.saveToJson(WordList.builder()
                .wordList(commonWords)
                .build(), JsonUtils.STORAGE_COMMON_WORDS);
    }

    /**receives the word from the common word list and copies it to the problem word list*/
    public static void addWordToProblem(String problemWordUid) {
        Map<String, Word> commonWords = Optional.ofNullable(JsonUtils.loadFromJson(WordList.class, JsonUtils.STORAGE_COMMON_WORDS))
                .map(WordList::getWordList)
                .orElse(Collections.emptyMap());
        Optional.ofNullable(commonWords.get(problemWordUid))
                .ifPresent(word -> {
                    List<Word> problemWords = JsonManager.getProblemWords();
                    problemWords.add(word);
                    Map<String, Word> problemMap =
                            Optional.of(problemWords)
                            .orElse(Collections.emptyList())
                            .stream()
                            .collect(Collectors.toMap(Word::getUid, w -> w));

                    JsonUtils.saveToJson(WordList.builder()
                            .wordList(problemMap)
                            .build(), JsonUtils.STORAGE_COMMON_WORDS);
                });
    }

    private static List<Word> getWords(String storageProblemWords) {
        return Optional.ofNullable(JsonUtils.loadFromJson(WordList.class, storageProblemWords))
                .map(WordList::getWordList)
                .map(Map::values)
                .orElse(Collections.emptySet())
                .stream()
                .collect(Collectors.toList());
    }
}
