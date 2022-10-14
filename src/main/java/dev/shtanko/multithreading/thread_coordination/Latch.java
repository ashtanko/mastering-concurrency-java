package dev.shtanko.multithreading.thread_coordination;

public class Latch {
    private final Object lock = new Object();
    private volatile boolean flag = false;

    public void waitTillChange() {
        synchronized (lock) {
            while (!flag) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void change() {
        synchronized (lock) {
            flag = true;
            lock.notifyAll();
        }
    }
}
