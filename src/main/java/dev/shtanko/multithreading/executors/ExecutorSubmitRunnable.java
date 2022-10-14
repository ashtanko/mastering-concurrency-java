package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSubmitRunnable {
    public static void main(String[] args) throws ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous runnable task");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        try {
            future.get();  // returns null if the task has finished correctly.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
