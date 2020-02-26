package ru.aparfenov.vocabulary.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/** Represents the list of common words
 * Created by ArtemParfenov on 25.02.2020.
 */
@Data
@Builder
@Accessors(chain = true)
public class CommonWordsDto {
    private List<WordDto> commonWords;
}
