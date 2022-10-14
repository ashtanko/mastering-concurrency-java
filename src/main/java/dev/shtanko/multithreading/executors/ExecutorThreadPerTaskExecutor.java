package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.Executor;

public class ExecutorThreadPerTaskExecutor {
    public static void main(String[] args) {
        Executor threadPerTaskExecutor = new ThreadPerTaskExecutor();
        threadPerTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 1");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        threadPerTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 2");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });
    }
}
