package dev.shtanko.multithreading.synchronized_block;

/**
 * A synchronized block in Java can only be executed a single thread at a time
 * Synchronized Blocks in Instance Methods
 * You do not have to synchronize a whole method.
 * Sometimes it is preferable to synchronize only part of a method.
 * Java synchronized blocks inside methods makes this possible.
 */
public class SynchronizedBlock {

    private volatile int i;

    private void inc() {
        // no more than one thread will be able to access the code inside that block.
        // this means you can synchronize on the current instance (obtain lock on the current instance)
        // also called: block-level synchronization
        synchronized (this) {
            i++;
        }
    }

    private void dec() {
        synchronized (this) {
            i--;
        }
    }

    private int getI() {
        return i;
    }

    public static void main(String[] args) {
        SynchronizedBlock example = new SynchronizedBlock();
        // Atomic increment
        example.inc();

        // Atomic decrement
        example.dec();

        // Atomic reading
        System.out.println(example.getI());
    }
}
