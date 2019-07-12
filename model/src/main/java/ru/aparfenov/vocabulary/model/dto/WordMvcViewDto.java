package ru.aparfenov.vocabulary.model.dto;

/**
 * Created by ArtemParfenov on 11.07.2019.
 */
public class WordMvcViewDto {
    private String en;
    private String ru;
    private String transcr;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getTranscr() {
        return transcr;
    }

    public void setTranscr(String transcr) {
        this.transcr = transcr;
    }
}
