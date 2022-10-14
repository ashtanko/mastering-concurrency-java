package dev.shtanko.multithreading.executors;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorSerialExecutor {
    public static void main(String[] args) {
        Executor serialExecutor = new SerialExecutor(Executors.newSingleThreadExecutor());
        serialExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 1");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        serialExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 2");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });

        serialExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing runnable 3");
                ThreadInfoPrinter.print(Thread.currentThread());
            }
        });
    }
}
