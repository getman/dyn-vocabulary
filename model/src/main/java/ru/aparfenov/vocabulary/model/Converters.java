package ru.aparfenov.vocabulary.model;

import ru.aparfenov.vocabulary.model.dto.TranslationDto;
import ru.aparfenov.vocabulary.model.requests.AddNewWordRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArtemParfenov on 09.07.2019.
 */
public final class Converters {
    public static Word fromAddNewWordRequest(AddNewWordRequest addNewWordRequest) {
        Word newWord = new Word(addNewWordRequest.getNewWordEn());
        List<Translation> translationList = new ArrayList<>();
        for (TranslationDto nextTranslationDto: addNewWordRequest.getTranslationList()) {
            Translation newTr = new Translation();
            newTr.setTranslation(nextTranslationDto.getTranslation());
            Transcription newTranscr = new Transcription();
            newTranscr.setTranscription(nextTranslationDto.getTranscr());
            newTr.setTranscr(newTranscr);
            translationList.add(newTr);
        }
        newWord.setTranslationsRu(translationList);
        return newWord;
    }
}
