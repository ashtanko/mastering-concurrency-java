package dev.shtanko.multithreading.thread_pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
 * At any point, at most nThreads threads will be active processing tasks. If additional tasks are
 * submitted when all threads are active, they will wait in the queue until a thread is available. If any
 * thread terminates due to a failure during execution prior to shutdown, a new one will take its place if
 * needed to execute subsequent tasks. The threads in the pool will exist until it is explicitly shutdown.
 * Params:
 * nThreads – the number of threads in the pool
 * Returns:
 * the newly created thread pool
 * Throws:
 * IllegalArgumentException – if nThreads <= 0
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            Thread.sleep(500);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(500);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(500);
            return null;
        });

        System.out.println(executor.getPoolSize()); // 2
        System.out.println(executor.getQueue().size()); // 1
        executor.shutdown();
    }
}
