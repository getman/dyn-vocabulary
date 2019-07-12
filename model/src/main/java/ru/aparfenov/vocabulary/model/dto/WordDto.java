package ru.aparfenov.vocabulary.model.dto;

import ru.aparfenov.vocabulary.model.Translation;

import java.util.List;

/** DTO object for the Word
 * Created by ArtemParfenov on 10.07.2019.
 */
public class WordDto {
    /**word`s UUID*/
    private String uid;
    /**word in english*/
    private String wordEn;
    /**translations of the word on Russian*/
    private List<TranslationDto> translationsRu;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }

    public List<TranslationDto> getTranslationsRu() {
        return translationsRu;
    }

    public void setTranslationsRu(List<TranslationDto> translationsRu) {
        this.translationsRu = translationsRu;
    }
}
