package dev.shtanko.multithreading.wait_notify;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Provider-Consumer Synchronize Problem with wait() and notifyAll()
*/
public class WaitNotifyExample<E> {

    private final Queue<E> data;

    public WaitNotifyExample() {
        data = new PriorityQueue<>();
    }

    public synchronized void provide(E element) throws InterruptedException {
        if (data.offer(element)) {
            System.out.println("Provided: " + data.size());
            this.notifyAll();
        } else {
            System.err.println("An element is not provided.");
        }
        Thread.sleep(300);
    }

    public synchronized void consume() throws InterruptedException {
        while (data.isEmpty()) {
            wait();
        }
        Thread.sleep(100);
        data.remove();
        System.err.println("Consumed: " + data.size());
        this.notifyAll();
    }

    public static void main(String[] args) {
        WaitNotifyExample<Integer> a = new WaitNotifyExample<>();

        // The first thread which call the provide method of A class and send number to queue.
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    a.provide(i);
                } catch (InterruptedException ignore) {
                }
            }
        }).start();

        // The second thread which call the consume method of A class for remove number from queue.
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    a.consume();
                } catch (InterruptedException ignore) {
                }
            }
        }).start();
    }
}
