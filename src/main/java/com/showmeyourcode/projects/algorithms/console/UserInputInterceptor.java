package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
public class UserInputInterceptor {
    private final Menu menu = new Menu();
    private final SortingAppConfiguration appConfiguration;
    private final UserInputProcessor userInputProcessor;

    public void startListening(InputStream inputStream) {
        Scanner scannerChoice = new Scanner(inputStream);
        Optional<UserMenuChoice> currentUserChoice = Optional.empty();
        do {
            if (currentUserChoice.isEmpty() || UserMenuChoice.BAD_USER_INPUT != currentUserChoice.get()) {
                log.info(menu.createMenuToDisplay(appConfiguration.defaultGeneratedDatasetSize()));
            }
            currentUserChoice = userChoice(scannerChoice.next());
            userInputProcessor.processUserInput(currentUserChoice.orElse(UserMenuChoice.BAD_USER_INPUT));
        } while (currentUserChoice.isPresent() && UserMenuChoice.EXIT != currentUserChoice.get());
    }

    Optional<UserMenuChoice> userChoice(String uChoice) {
        Optional<UserMenuChoice> result;
        if (String.valueOf(UserMenuChoice.EXIT.getUserChoice()).equals(uChoice)) {
            result = Optional.of(UserMenuChoice.EXIT);
        } else if (uChoice.matches("^\\d+$") &&
                Integer.parseInt(uChoice) <= UserMenuChoice.getHighestAvailableUserChoice()) {
            result = UserMenuChoice.of(Integer.parseInt(uChoice));
        } else {
            result = Optional.of(UserMenuChoice.BAD_USER_INPUT);
        }
        return result;
    }
}
