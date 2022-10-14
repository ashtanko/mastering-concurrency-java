package dev.shtanko.multithreading.thread_coordination;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LatchCondition {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile boolean flag = false;

    public void waitTillChange() {
        lock.lock();
        try {
            while (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void change() {
        lock.lock();
        try {
            flag = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
