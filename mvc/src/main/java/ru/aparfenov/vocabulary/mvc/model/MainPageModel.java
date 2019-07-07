package ru.aparfenov.vocabulary.mvc.model;

import ru.aparfenov.vocabulary.model.Word;

import java.util.List;

/**
 * Created by ArtemParfenov on 05.02.2019.
 */
public class MainPageModel {
    private List<Word> generalWords;
    private List<Word> problemWords;

    public List<Word> getGeneralWords() {
        return generalWords;
    }

    public void setGeneralWords(List<Word> generalWords) {
        this.generalWords = generalWords;
    }

    public List<Word> getProblemWords() {
        return problemWords;
    }

    public void setProblemWords(List<Word> problemWords) {
        this.problemWords = problemWords;
    }
}
