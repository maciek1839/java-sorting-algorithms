package com.showmeyourcode.projects.algorithms;

import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Welcome to The Sorting Algorithms program.");
        startApp();
    }

    static void startApp() {
        final UserInputInterceptor inputInterceptor = new UserInputInterceptor();
        inputInterceptor.startListening();
    }
}
