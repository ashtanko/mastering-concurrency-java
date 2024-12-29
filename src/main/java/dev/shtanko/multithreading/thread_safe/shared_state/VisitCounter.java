package dev.shtanko.multithreading.thread_safe.shared_state;

import dev.shtanko.multithreading.GuardedBy;
import dev.shtanko.multithreading.ThreadSafe;

import java.util.concurrent.Executors;

@ThreadSafe
public class VisitCounter {

    @GuardedBy("this")
    private int value;

    public synchronized int actualValue() {
        return value;
    }

    public synchronized void increase() {
        value++;
    }

    public synchronized void decrease() {
        value--;
    }

    public static void main(String[] args) {
        var counter = new VisitCounter();
        var threadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 500_000; i++) {
            threadPool.execute(counter::increase);
        }
        for (int i = 1; i <= 500_000; i++) {
            threadPool.execute(counter::decrease);
        }
        threadPool.shutdown();
        System.out.println(counter.actualValue()); // should be zero
    }
}
