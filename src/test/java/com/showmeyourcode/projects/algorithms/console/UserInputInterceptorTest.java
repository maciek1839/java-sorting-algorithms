package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.constant.UserMenuChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputInterceptorTest {

    @Test
    void shouldProperlyParseExitOption() {
        assertEquals(UserMenuChoice.EXIT, new UserInputInterceptor().userChoice("11"));
    }
}
