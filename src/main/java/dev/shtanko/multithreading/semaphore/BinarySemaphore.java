package dev.shtanko.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class BinarySemaphore {
    public static void main(String[] args) {
        final int threadCount = 5;
        final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
        final Printer printer = new Printer();
        for (int i = 1; i <= threadCount; i++) {
            exService.execute(new Job(printer, "Job-" + i));
        }
        exService.shutdown();
    }

    public static class Printer {
        private static final int MAX_PERMIT = 1;
        private final Semaphore semaphore = new Semaphore(MAX_PERMIT, true);

        public void print(String jobName) {
            try {
                semaphore.acquire();
                System.out.println("Printing Job: " + jobName);
                Thread.sleep(2000);
                System.out.println("Finished Job: " + jobName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static class Job implements Runnable {
        private final Printer printer;
        private final String jobName;

        public Job(Printer printer, String jobName) {
            this.printer = printer;
            this.jobName = jobName;
        }

        @Override
        public void run() {
            System.out.println("Job sent to printer:" + jobName);
            printer.print(jobName);
        }
    }
}
