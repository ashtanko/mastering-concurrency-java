package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.Executor;

public class ExecutorDirectExecutor {
    public static void main(String[] args) {
        Executor directExecutor = new DirectExecutor();
        directExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 1");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        directExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 2");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });
    }
}
