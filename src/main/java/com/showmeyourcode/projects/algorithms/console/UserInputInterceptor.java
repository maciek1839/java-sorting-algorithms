package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.constant.UserMenuChoice;

import java.util.Scanner;

public class UserInputInterceptor {
    private final Menu menu = new Menu();
    private final UserInputProcessor userInputProcessor = new UserInputProcessor();

    public void startListening() {
        Scanner scannerChoice = new Scanner(System.in);
        UserMenuChoice currentUserChoice;
        do {
            menu.displayMenu();
            currentUserChoice = userChoice(scannerChoice.next());
            userInputProcessor.processUserInput(currentUserChoice);
        } while (UserMenuChoice.EXIT != currentUserChoice);
    }

    UserMenuChoice userChoice(String uChoice) {
        UserMenuChoice result;
        if (uChoice.equals(String.valueOf(UserMenuChoice.EXIT.getUserChoice())))
            result = UserMenuChoice.EXIT;
        else if (uChoice.length() > 1 || uChoice.matches("(.*)[a-zA-Z](.*)"))
            result = UserMenuChoice.BAD_USER_INPUT;
        else
            result = UserMenuChoice.of(Integer.parseInt(uChoice));
        return result;
    }
}
