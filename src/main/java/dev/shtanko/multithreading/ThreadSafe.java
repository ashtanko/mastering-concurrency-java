package dev.shtanko.multithreading;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to indicate that a class or type is thread-safe.
 * <p>
 * A class annotated with {@code @ThreadSafe} guarantees safe concurrent access by multiple threads
 * without additional synchronization on the part of the callers. This annotation can be applied
 * to types such as classes and interfaces.
 * </p>
 *
 * <p>Usage:</p>
 * <pre>
 * {@code
 * @ThreadSafe
 * public class SafeCounter {
 *     private int count = 0;
 *
 *     public synchronized void increment() {
 *         count++;
 *     }
 *
 *     public synchronized int getCount() {
 *         return count;
 *     }
 * }
 * }
 * </pre>
 *
 * <p>Retention policy:</p>
 * The {@code @ThreadSafe} annotation is retained at runtime, allowing runtime tools
 * to inspect it using reflection.
 *
 * <p>Target:</p>
 * This annotation can only be applied to types (classes, interfaces, enums, etc.).
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
