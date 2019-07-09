package ru.aparfenov.vocabulary.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.aparfenov.vocabulary.model.Converters;
import ru.aparfenov.vocabulary.model.Word;
import ru.aparfenov.vocabulary.model.requests.AddNewWordRequest;
import ru.aparfenov.vocabulary.mvc.model.AddNewWordPageModel;
import ru.aparfenov.vocabulary.mvc.model.MainPageModel;
import ru.aparfenov.vocabulary.storage.WordStorageDao;

/** MVC controller for the main application page
 * Created by ArtemParfenov on 05.02.2019.
 */
@Controller
public class MainPageController {
    @Autowired
    private WordStorageDao wordStorageDao;

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView mv = new ModelAndView("mainPage");

        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setGeneralWords(wordStorageDao.getGeneralWords());
        mainPageModel.setProblemWords(wordStorageDao.getProblemWords());

        return mv.addObject("mainPageModel", mainPageModel);
    }

    @RequestMapping(value = "/add-word", method = RequestMethod.POST)
    public ModelAndView addWord(@RequestBody AddNewWordRequest newWordRequest) {
        wordStorageDao.addWord(Converters.fromAddNewWordRequest(newWordRequest));

        ModelAndView mv = new ModelAndView("mainPage");
        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setGeneralWords(wordStorageDao.getGeneralWords());
        mainPageModel.setProblemWords(wordStorageDao.getProblemWords());

        return mv.addObject("mainPageModel", mainPageModel);
    }

}
