package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

public class UserInputInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(UserInputInterceptor.class);
    private final Menu menu = new Menu();
    private final UserInputProcessor userInputProcessor;

    public UserInputInterceptor(SortingAppConfiguration appConfiguration) {
        userInputProcessor = new UserInputProcessor(appConfiguration);
    }

    public void startListening(InputStream inputStream) {
        Scanner scannerChoice = new Scanner(inputStream);
        Optional<UserMenuChoice> currentUserChoice = Optional.empty();
        do {
            if (currentUserChoice.isEmpty() || UserMenuChoice.BAD_USER_INPUT != currentUserChoice.get()) {
                logger.info(menu.createMenu());
            }
            currentUserChoice = userChoice(scannerChoice.next());
            userInputProcessor.processUserInput(currentUserChoice.get());
        } while (currentUserChoice.isPresent() && UserMenuChoice.EXIT != currentUserChoice.get());
    }

    Optional<UserMenuChoice> userChoice(String uChoice) {
        Optional<UserMenuChoice> result;
        if (String.valueOf(UserMenuChoice.EXIT.getUserChoice()).equals(uChoice)) {
            result = Optional.of(UserMenuChoice.EXIT);
        } else if (uChoice.matches("^[0-9]+$") &&
                Integer.parseInt(uChoice) <= UserMenuChoice.getHighestAvailableUserChoice()) {
            result = UserMenuChoice.of(Integer.parseInt(uChoice));
        } else {
            result = Optional.of(UserMenuChoice.BAD_USER_INPUT);
        }
        return result;
    }
}
