package com.showmeyourcode.projects.algorithms.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Waiting extends Thread {

    private static final long WAITING_PRINT_PERIOD = 100000000L;
    private volatile boolean isDone;
    private final Logger logger = LoggerFactory.getLogger(Waiting.class);

    Waiting() {
        isDone = false;
    }

    @Override
    public void run() {
        logger.info("Keep waiting ");
        long counter = 0;
        while (!isDone) {
            if (counter % WAITING_PRINT_PERIOD == 0)
                logger.info("Still processing");
            counter++;
        }
    }

    public void setDone() {
        isDone = true;
    }
}
