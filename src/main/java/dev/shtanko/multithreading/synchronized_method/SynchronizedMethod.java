package dev.shtanko.multithreading.synchronized_method;

public class SynchronizedMethod {
    private volatile int i;

    public synchronized void inc() {
        i++;
    }

    public synchronized void dec() {
        i--;
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        SynchronizedMethod a = new SynchronizedMethod();

        // Atomic increment
        a.inc();

        // Atomic decrement
        a.dec();

        // Atomic reading
        System.out.println(a.getI());
    }
}
