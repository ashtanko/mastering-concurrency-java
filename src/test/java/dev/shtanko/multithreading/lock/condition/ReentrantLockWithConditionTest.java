package dev.shtanko.multithreading.lock.condition;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ReentrantLockWithConditionTest {
    @Test
    void testPushAndPopSingleThread() throws InterruptedException {
        ReentrantLockWithCondition lockWithCondition = new ReentrantLockWithCondition();

        lockWithCondition.pushToStack("Item1");
        lockWithCondition.pushToStack("Item2");

        assertEquals("Item2", lockWithCondition.popFromStack());
        assertEquals("Item1", lockWithCondition.popFromStack());
    }

    @Test
    void testPushBlocksWhenFull() throws InterruptedException {
        ReentrantLockWithCondition lockWithCondition = new ReentrantLockWithCondition();

        // Fill the stack to its capacity
        for (int i = 0; i < 5; i++) {
            lockWithCondition.pushToStack("Item" + i);
        }

        var executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                lockWithCondition.pushToStack("ExtraItem");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Allow time for the thread to block
        Thread.sleep(100);
        assertEquals(5, lockWithCondition.size());

        // Pop one item to free space
        assertEquals("Item4", lockWithCondition.popFromStack());

        // Wait for the thread to finish pushing
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(5, lockWithCondition.size());
        assertEquals("ExtraItem", lockWithCondition.popFromStack());
    }

    @Test
    void testPopBlocksWhenEmpty() throws InterruptedException {
        ReentrantLockWithCondition lockWithCondition = new ReentrantLockWithCondition();

        var executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Thread.sleep(100); // Simulate delay
                lockWithCondition.pushToStack("DelayedItem");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        String result = lockWithCondition.popFromStack();
        assertEquals("DelayedItem", result);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }

    @Test
    void testMultiThreadedPushAndPop() throws InterruptedException {
        ReentrantLockWithCondition lockWithCondition = new ReentrantLockWithCondition();
        var executor = Executors.newFixedThreadPool(3);

        // Pusher threads
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    lockWithCondition.pushToStack("Item" + finalI);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Popper threads
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    lockWithCondition.popFromStack();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        assertFalse(lockWithCondition.isEmpty());
    }
}
