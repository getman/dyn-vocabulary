package ru.aparfenov.vocabulary.mvc.model;

import ru.aparfenov.vocabulary.model.Word;

/** Page model for adding a new word
 * Created by ArtemParfenov on 09.07.2019.
 */
public class AddNewWordPageModel {
    /**the new word*/
    private Word newWordEn;

    public Word getNewWordEn() {
        return newWordEn;
    }

    public void setNewWordEn(Word newWordEn) {
        this.newWordEn = newWordEn;
    }
}
