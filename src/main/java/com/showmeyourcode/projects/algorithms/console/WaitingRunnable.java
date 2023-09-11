package com.showmeyourcode.projects.algorithms.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitingRunnable implements Runnable {

    private static final long WAITING_PRINT_PERIOD = 10_000_000_000L;
    private static final Logger logger = LoggerFactory.getLogger(WaitingRunnable.class);
    private volatile boolean isDone;

    WaitingRunnable() {
        isDone = false;
    }

    @Override
    public void run() {
        logger.info("Keep waiting");
        long counter = 0;
        while (!isDone) {
            if (counter % WAITING_PRINT_PERIOD == 0)
                logger.info("Still processing...");
            counter++;
        }
    }

    public void setDone() {
        isDone = true;
    }
}
