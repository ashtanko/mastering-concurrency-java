package dev.shtanko.multithreading.thread_cotrol;

class RunnableDemo implements Runnable {
    public Thread t;
    private final String threadName;
    boolean suspended = false;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(300);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}

public class ThreadControl {

    public static void main(String[] args) {

        RunnableDemo thread1 = new RunnableDemo("Thread-1");
        thread1.start();

        RunnableDemo thread2 = new RunnableDemo("Thread-2");
        thread2.start();

        try {
            Thread.sleep(1000);
            thread1.suspend();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            thread1.resume();
            System.out.println("Resuming First Thread");

            thread2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            thread2.resume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        try {
            System.out.println("Waiting for threads to finish.");
            thread1.t.join();
            thread2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
