package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorRunnable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            public void run() {
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        executorService.shutdown();
    }
}
