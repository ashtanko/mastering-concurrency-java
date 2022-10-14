package dev.shtanko.multithreading.monitor;

/**
 * The CubbyHole class for the producer/consumer example
 */
class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}
