package dev.shtanko.multithreading.callable_and_future;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new TimeoutException("Sleeping for too long.");
                }
                System.out.println("Starting ...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();

        try {
            // get returned value from call()
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
