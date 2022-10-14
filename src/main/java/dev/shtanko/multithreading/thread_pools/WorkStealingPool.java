package dev.shtanko.multithreading.thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkStealingPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(4);
        ThreadPoolExecutor myPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ;
        System.out.println("size of: " + myPool.getPoolSize());
        executor.submit(new ThreadImpl());
        executor.submit(new ThreadImpl());
        System.out.println("Total number threads scheduled): " + myPool.getTaskCount());
        executor.shutdown();
    }

    static class ThreadImpl implements Runnable {

        public void run() {

            try {
                long num = (long) (Math.random() / 30);
                System.out.println("Thread Name: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(num);
                System.out.println("after sleep Thread Name: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
