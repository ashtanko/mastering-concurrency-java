package dev.shtanko.multithreading.daemon;

import dev.shtanko.multithreading.utils.ThreadInfoPrinter;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                ThreadInfoPrinter.print(Thread.currentThread());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Setting daemon.
        thread.setDaemon(true);

        // Starting thread.
        thread.start();

        Thread.sleep(100L);
    }
}
