package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSubmitCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("Asynchronous Callable");
                ThreadInfoPrinter.print(Thread.currentThread());
                return "Callable Result";
            }
        });

        try {
            System.out.println("future.get() = " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
