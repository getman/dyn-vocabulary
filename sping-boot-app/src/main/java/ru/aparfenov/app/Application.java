package ru.aparfenov.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ArtemParfenov on 02.02.2020.
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"ru.aparfenov.app", "ru.aparfenov.vocabulary.storage"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
