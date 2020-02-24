package ru.aparfenov.vocabulary.model;

import ru.aparfenov.vocabulary.model.dto.TranslationDto;
import ru.aparfenov.vocabulary.model.dto.WordDto;
import ru.aparfenov.vocabulary.model.dto.WordMvcViewDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArtemParfenov on 09.07.2019.
 */
public final class Converters {
    public static Word fromDto(WordDto addNewWordRequest) {
        Word newWord = new Word(addNewWordRequest.getWordEn());
        List<Translation> translationList = new ArrayList<>();
        for (TranslationDto nextTranslationDto: addNewWordRequest.getTranslationsRu()) {
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

    public static Word fromViewDto(WordMvcViewDto wordMvcViewDto) {
        Word newWord = new Word(wordMvcViewDto.getEn());
        List<Translation> translationList = new ArrayList<>();
        Translation t = new Translation();
        t.setTranslation(wordMvcViewDto.getRu());
        Transcription tr = new Transcription();
        tr.setTranscription(wordMvcViewDto.getTranscr());
        t.setTranscr(tr);
        translationList.add(t);
        newWord.setTranslationsRu(translationList);
        return newWord;
    }
}
