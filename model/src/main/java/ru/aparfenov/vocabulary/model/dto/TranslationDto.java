package ru.aparfenov.vocabulary.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by ArtemParfenov on 09.07.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class TranslationDto {
    /**the translation*/
    private String translation;
    /**word`s transcription*/
    private String transcr;
}
