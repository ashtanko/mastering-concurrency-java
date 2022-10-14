package dev.shtanko.multithreading.thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
    }
}
