package ru.aparfenov.vocabulary.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aparfenov.vocabulary.model.Converters;
import ru.aparfenov.vocabulary.model.dto.WordDto;
import ru.aparfenov.vocabulary.model.dto.WordMvcViewDto;
import ru.aparfenov.vocabulary.model.exceptions.WordNotFoundException;
import ru.aparfenov.vocabulary.mvc.model.MainPageModel;
import ru.aparfenov.vocabulary.storage.WordStorageDao;

import javax.validation.Valid;

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

        return mv.addObject("mainPageModel", mainPageModel)
                .addObject("new-word", new WordMvcViewDto());
    }

    @RequestMapping(value = "/add-word", method = RequestMethod.POST)
    public ModelAndView addWord(
            @Valid @ModelAttribute("new-word") WordMvcViewDto wordViewDto
            ) {
        wordStorageDao.addWord(Converters.fromViewDto(wordViewDto));
        //route request to the mainPage url
        return new ModelAndView("redirect:mainPage");
    }

    @RequestMapping(value = "/update-word", method = RequestMethod.POST)
    public ModelAndView updateWord(@RequestBody WordDto newWordRequest) {
        try {
            wordStorageDao.updateWord(Converters.fromDto(newWordRequest));
        } catch (WordNotFoundException e) {
            e.printStackTrace();
        }
        //route request to the mainPage url
        return new ModelAndView("redirect:mainPage");
    }

}
