package ru.aparfenov.vocabulary.model;

import java.util.List;

/** Domain object, represents a word in English
 * Created by ArtemParfenov on 05.02.2019.
 */
public class Word {
    /**word`s UUID*/
    private String uid;
    /**translations of the word on Russian*/
    private List<Translation> translationsRu;
    /**word in english*/
    private String wordEn;

    public Word(String wordEn) {
        this.wordEn = wordEn;
    }

    public List<Translation> getTranslationsRu() {
        return translationsRu;
    }

    public void setTranslationsRu(List<Translation> translationsRu) {
        this.translationsRu = translationsRu;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
