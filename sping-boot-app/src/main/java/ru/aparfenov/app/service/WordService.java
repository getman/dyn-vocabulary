package ru.aparfenov.app.service;

import org.springframework.stereotype.Component;
import ru.aparfenov.app.exception.StorageConnectionException;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Component
public class WordService {
    public String traslate() {
        return "Hello World!";
    }
}
