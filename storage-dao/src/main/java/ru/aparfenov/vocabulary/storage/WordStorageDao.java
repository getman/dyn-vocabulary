package ru.aparfenov.vocabulary.storage;

import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.exceptions.WordNotFoundException;

import java.util.List;

/** interface of the words storage
 * Created by ArtemParfenov on 06.02.2019.
 */
public interface WordStorageDao {
    /**returns a list of usual words in alphabetical order*/
    public List<Word> getGeneralWords();
    /**returns a list of problem words (that are requested very often)*/
    public List<Word> getProblemWords();
    /**adds a new word to the storage*/
    public void addWord(Word newWord);
    /**adds an existed word to the problem list*/
    public void addWordToProblem(String problemWordUid);
    /**updates an existing word*/
    public void updateWord(Word targetWord) throws WordNotFoundException;
    /**removes an existing word*/
    public void removeWord() throws WordNotFoundException;
}
