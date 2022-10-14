package dev.shtanko.multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    public int incrementAndGet() {
        return count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}

public class AtomicIntegerExample {

    private static final int ITEMS_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        AtomicCounter atomicCounter = new AtomicCounter();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            executorService.submit(atomicCounter::incrementAndGet);
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final Count is : " + atomicCounter.getCount() + " should be: " + ITEMS_COUNT);
    }
}
