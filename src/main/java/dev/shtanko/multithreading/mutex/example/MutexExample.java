package dev.shtanko.multithreading.mutex.example;

public class MutexExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Create threads that increment the shared resource
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the result
        System.out.println("Final count: " + resource.getCount());
    }
}
