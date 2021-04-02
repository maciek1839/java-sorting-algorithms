package com.showmeyourcode.projects.algorithms.console;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * See more: https://www.baeldung.com/thread-pool-java-and-guava
 */
public class WaitingExecutorService {
    private final Executor executor = Executors.newSingleThreadExecutor();

    public void execute(Runnable task) {
        executor.execute(task);
    }
}
