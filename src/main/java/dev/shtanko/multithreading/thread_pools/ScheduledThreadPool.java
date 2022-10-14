package dev.shtanko.multithreading.thread_pools;

import java.util.concurrent.*;

public class ScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        boolean result = lock.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("Result: " + result);
        future.cancel(true);
    }
}
