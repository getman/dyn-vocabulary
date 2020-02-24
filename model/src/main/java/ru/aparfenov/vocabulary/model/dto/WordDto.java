package ru.aparfenov.vocabulary.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/** DTO object for the Word
 * Created by ArtemParfenov on 10.07.2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class WordDto {
    /**word`s UUID*/
    private String uid;
    /**word in english*/
    private String wordEn;
    /**translations of the word on Russian*/
    private List<TranslationDto> translationsRu;
}
