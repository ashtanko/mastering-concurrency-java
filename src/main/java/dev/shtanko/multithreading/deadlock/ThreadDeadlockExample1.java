package dev.shtanko.multithreading.deadlock;

public class ThreadDeadlockExample1 {

    public static Object firstLock = new Object();
    public static Object secondLock = new Object();

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();

        firstTask.start();
        secondTask.start();
    }

    private static class FirstTask extends Thread {
        public void run() {
            synchronized (firstLock) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (secondLock) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    private static class SecondTask extends Thread {
        public void run() {
            synchronized (secondLock) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (firstLock) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
