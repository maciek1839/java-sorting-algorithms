package com.showmeyourcode.projects.algorithms.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserMenuChoice {
    BAD_USER_INPUT(0),
    ALGORITHM_1(1),
    ALGORITHM_2(2),
    ALGORITHM_3(3),
    ALGORITHM_4(4),
    ALGORITHM_5(5),
    ALGORITHM_6(6),
    ALGORITHM_7(7),
    ALGORITHM_8(8),
    ALGORITHM_9(9),
    EXIT(11);

    private static final Map<Integer, UserMenuChoice> enumMap = new HashMap<>(values().length, 1);

    static {
        for (UserMenuChoice c : values()) enumMap.put(c.getUserChoice(), c);
    }

    private final int userChoice;

    UserMenuChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public static UserMenuChoice of(int userChoice) {
        return enumMap.get(userChoice);
    }

    public int getUserChoice() {
        return userChoice;
    }
}
