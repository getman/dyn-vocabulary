package ru.aparfenov.dynvocabulary.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public abstract class JsonUtils {
    public static final String STORAGE_COMMON_WORDS = ".\\json-storage\\common-words";
    public static final String STORAGE_PROBLEM_WORDS = ".\\json-storage\\problem-words";

    public static <T> void saveToJson(T object, String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            log.error("Something went wrong while trying to serialize object to JSON", e);
        }

    }

    public static <T> T loadFromJson(Class<T> objectClassName, String fileName) {
        Gson gson = new Gson();
        // 1. JSON file to Java object
        try (FileReader reader = new FileReader("C:\\projects\\staff.json")) {
            return gson.fromJson(reader, objectClassName);
        } catch (FileNotFoundException e) {
            log.error("Json file was not found", e);
        } catch (IOException e) {
            log.error("Some error occurred while trying to parse Json file", e);
        }
        return null;
    }
}
