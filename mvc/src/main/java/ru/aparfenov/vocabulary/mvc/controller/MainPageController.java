package ru.aparfenov.vocabulary.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.aparfenov.vocabulary.mvc.model.MainPageModel;
import ru.aparfenov.vocabulary.storage.WordStorageDao;

/**
 * Created by ArtemParfenov on 05.02.2019.
 */
@Controller
public class MainPageController {
    @Autowired
    private WordStorageDao wordStorageDao;

    @RequestMapping(value = "/mainPage")
    public ModelAndView getHomePage() {
        ModelAndView mv = new ModelAndView("mainPage");

        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setGeneralWords(wordStorageDao.getGeneralWords());
        mainPageModel.setProblemWords(wordStorageDao.getProblemWords());

        return mv.addObject("mainPageModel", mainPageModel);
    }


}
