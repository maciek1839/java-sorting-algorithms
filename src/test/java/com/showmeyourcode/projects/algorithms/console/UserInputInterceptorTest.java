package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.constant.UserMenuChoice;
import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputInterceptorTest {

    @Test
    void should_properlyParseExitOption_when_pressExitDigit() {
        assertEquals(UserMenuChoice.EXIT, new UserInputInterceptor(StaticValueProvider.getConfig()).userChoice("11"));
    }
}
