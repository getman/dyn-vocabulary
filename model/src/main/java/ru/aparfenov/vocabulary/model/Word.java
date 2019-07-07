package ru.aparfenov.vocabulary.model;

import java.util.List;

/** represents a word in English
 * Created by ArtemParfenov on 05.02.2019.
 */
public class Word {
    /**translations of the word*/
    private List<Translation> translations;
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
