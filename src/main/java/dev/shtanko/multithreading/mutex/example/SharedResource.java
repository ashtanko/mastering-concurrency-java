package dev.shtanko.multithreading.mutex.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++; // Critical section
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public int getCount() {
        return count;
    }
}
