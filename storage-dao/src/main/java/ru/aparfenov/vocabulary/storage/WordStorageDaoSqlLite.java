package ru.aparfenov.vocabulary.storage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.exceptions.WordNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArtemParfenov on 06.02.2019.
 */
@Component
@Scope("prototype")
public class WordStorageDaoSqlLite implements WordStorageDao {
    @Override
    public List<Word> getGeneralWords() {
        List<Word> res = new ArrayList<Word>();
        res.add(new Word("gen word1"));
        res.add(new Word("gen word2"));
        res.add(new Word("gen word3"));
        return res;
    }

    @Override
    public List<Word> getProblemWords() {
        List<Word> res = new ArrayList<Word>();
        res.add(new Word("probl word1"));
        res.add(new Word("probl word2"));
        res.add(new Word("probl word3"));
        return res;
    }

    @Override
    public void addWord(Word newWord) {

    }

    @Override
    public void addWordToProblem(String problemWordUid) {

    }

    @Override
    public void updateWord(Word targetWord) throws WordNotFoundException {

    }

    @Override
    public void removeWord() throws WordNotFoundException {

    }
}
