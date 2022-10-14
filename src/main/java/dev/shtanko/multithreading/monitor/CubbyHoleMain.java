package dev.shtanko.multithreading.monitor;

import java.util.concurrent.TimeUnit;

public class CubbyHoleMain {

    private static final int INITIAL_CAPACITY = 1000;

    public static void main(String[] args) throws InterruptedException {
        CubbyHole cubbyHole = new CubbyHole();

        Thread writeTask = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < INITIAL_CAPACITY; i++) {
                    System.out.println("write: " + i);
                    cubbyHole.put(i);
                }
            }
        });

        Thread readTask = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= INITIAL_CAPACITY; i++) {
                    System.out.println("read: " + cubbyHole.get());
                }
            }
        });

        writeTask.start();
        readTask.start();
        TimeUnit.SECONDS.sleep(1);

    }
}
