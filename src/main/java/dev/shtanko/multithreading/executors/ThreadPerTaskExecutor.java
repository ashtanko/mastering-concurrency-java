package dev.shtanko.multithreading.executors;

import java.util.concurrent.Executor;

class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}
