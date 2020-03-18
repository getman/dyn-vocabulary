package ru.aparfenov.vocabulary.storage.json;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.exceptions.WordNotFoundException;
import ru.aparfenov.vocabulary.storage.WordStorageDao;

import java.util.List;

@Component
@Scope("prototype")
public class WordStorageDaoJson implements WordStorageDao {
    @Override
    public List<Word> getGeneralWords() {
        return JsonManager.getCommonWords();
    }

    @Override
    public List<Word> getProblemWords() {
        return JsonManager.getProblemWords();
    }

    @Override
    public void addWord(Word newWord) {
        JsonManager.addWord(newWord);
    }

    @Override
    public void addWordToProblem(String problemWordUid) {
        JsonManager.addWordToProblem(problemWordUid);
    }

    @Override
    public void updateWord(Word targetWord) throws WordNotFoundException {

    }

    @Override
    public void removeWord() throws WordNotFoundException {

    }
}
