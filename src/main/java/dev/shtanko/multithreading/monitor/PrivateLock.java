package dev.shtanko.multithreading.monitor;

public class PrivateLock {
    private final Object lock = new Object();
    private int i = 0;

    void someMethod() {
        synchronized (lock) {
            // access or modify i
            i++;
        }
    }
}
