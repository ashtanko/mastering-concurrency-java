package dev.shtanko.multithreading.thread_pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Creates a thread pool that creates new threads as needed, but will reuse previously constructed
 * threads when they are available. These pools will typically improve the performance of programs that
 * execute many short-lived asynchronous tasks. Calls to execute will reuse previously constructed
 * threads if available. If no existing thread is available, a new thread will be created and added to the
 * pool. Threads that have not been used for sixty seconds are terminated and removed from the cache.
 * Thus, a pool that remains idle for long enough will not consume any resources. Note that pools with
 * similar properties but different details (for example, timeout parameters) may be created using
 * ThreadPoolExecutor constructors.
 * Returns:
 * the newly created thread pool
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        System.out.println(executor.getPoolSize()); // 3
        System.out.println(executor.getQueue().size()); // 0
        executor.shutdown();
    }
}
