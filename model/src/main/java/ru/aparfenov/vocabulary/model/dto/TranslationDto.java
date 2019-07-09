package ru.aparfenov.vocabulary.model.dto;

/**
 * Created by ArtemParfenov on 09.07.2019.
 */
public class TranslationDto {
    /**the translation*/
    private String translation;
    /**word`s transcription*/
    private String transcr;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranscr() {
        return transcr;
    }

    public void setTranscr(String transcr) {
        this.transcr = transcr;
    }
}
