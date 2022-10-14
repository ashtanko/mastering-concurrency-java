package dev.shtanko.multithreading.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicAndDataTypes {

    // Here reading and modification variable is not thread safe.
    // Because of in threads the variable will be cached.
    private int a;

    // Here atomically reading of variable, because of have final modifier.
    // But, atomically modification is not thread safe.
    private final int b = 1;

    // Here reading and modification variable is thread safe.
    // But, non-atomic on operations such as increment, decrement is not thread safe.
    private volatile int c;

    // Here reading and modification variable is thread safe.
    // Also, you can use incrementAndGet(), decrementAndGet() and etc. methods
    // to non-atomic operations.
    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final AtomicBoolean atomicBoolean = new AtomicBoolean();
    private final AtomicLong atomicLong = new AtomicLong();

    private final AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(2);
    private final AtomicLongArray atomicLongArray = new AtomicLongArray(2);
    private AtomicReferenceArray<Integer> atomicReferenceArray;

    private AtomicIntegerFieldUpdater<Integer> atomicIntegerFieldUpdater;
    private AtomicLongFieldUpdater<Integer> atomicLongFieldUpdater;

    private final AtomicReference<Integer> atomicReference = new AtomicReference<>();
    private AtomicMarkableReference<Integer> atomicMarkableReference;
    private AtomicStampedReference<Integer> atomicStampedReference;


    public static void main(String[] args) {

    }
}
