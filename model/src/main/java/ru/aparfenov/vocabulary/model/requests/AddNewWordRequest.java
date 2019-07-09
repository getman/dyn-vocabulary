package ru.aparfenov.vocabulary.model.requests;

import ru.aparfenov.vocabulary.model.dto.TranslationDto;

import java.util.List;

/** Request for adding a new word to the database
 * Created by ArtemParfenov on 09.07.2019.
 */
public class AddNewWordRequest {
    private String newWordEn;
    private List<TranslationDto> translationList;

    public String getNewWordEn() {
        return newWordEn;
    }

    public void setNewWordEn(String newWordEn) {
        this.newWordEn = newWordEn;
    }

    public List<TranslationDto> getTranslationList() {
        return translationList;
    }

    public void setTranslationList(List<TranslationDto> translationList) {
        this.translationList = translationList;
    }
}
