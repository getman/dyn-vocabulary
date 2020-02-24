package ru.aparvenov.dynvocabulary;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.aparfenov.app.Application;
import ru.aparfenov.app.service.WordService;
import ru.aparfenov.vocabulary.model.dto.WordDto;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/** Testing translate controller
 * Created by ArtemParfenov on 21.02.2020.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TraslateControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WordService wordService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldTranslateMethodResponseOk() throws Exception {
        given(wordService.traslate(Mockito.any(WordDto.class))).willReturn("translate");
        mvc.perform(get("/translate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(WordDto.builder()
                        .wordEn("hello")
                        .build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("translate"));
    }

    @Test
    public void shouldUpdateWordResponseOk() throws Exception {
        Mockito.doNothing().when(wordService).updateWord(Mockito.any(WordDto.class));
        mvc.perform(post("/update-word")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"uid\":\"1234\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddNewWordResponseOk() throws Exception {
        Mockito.doNothing().when(wordService).addNewWord(Mockito.any(WordDto.class));
        mvc.perform(put("/add-new-word")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"uid\":\"1234\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddWordToProblemeResponseOk() throws Exception {
        Mockito.doNothing().when(wordService).addWordToProblem(Mockito.anyString());
        mvc.perform(post("/add-word-to-problem")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"uid\":\"1234\"}"))
                .andExpect(status().isOk());
    }
}