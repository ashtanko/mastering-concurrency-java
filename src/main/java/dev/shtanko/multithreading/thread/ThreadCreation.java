package dev.shtanko.multithreading.thread;

public class ThreadCreation {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        thread.start(); // starting thread
    }
}
