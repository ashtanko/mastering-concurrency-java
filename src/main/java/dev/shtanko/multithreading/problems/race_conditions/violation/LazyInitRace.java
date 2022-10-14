package dev.shtanko.multithreading.problems.race_conditions.violation;

import dev.shtanko.multithreading.NotThreadSafe;

/**
 * Race Condition in Lazy Initialization. Don't Do this
 */
@NotThreadSafe
public class LazyInitRace {
    private Object instance = null;

    public Object getInstance() {
        if (instance == null)
            instance = new Object();
        return instance;
    }
}
