package ru.aparfenov.vocabulary.model;

/**Translation domain object for the word
 * Created by ArtemParfenov on 05.02.2019.
 */
public class Translation {
    /**translation UUID*/
    private String uid;
    /**word`s transcription*/
    private Transcription transcr;
    /**the translation*/
    private String translation;

    public Transcription getTranscr() {
        return transcr;
    }

    public void setTranscr(Transcription transcr) {
        this.transcr = transcr;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
