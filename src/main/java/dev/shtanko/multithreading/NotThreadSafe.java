package dev.shtanko.multithreading;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to indicate that a class or type is not thread-safe.
 * <p>
 * A class annotated with {@code @NotThreadSafe} should not be accessed by multiple threads
 * simultaneously unless external synchronization is provided. This annotation serves as a warning
 * to developers to be cautious when using or extending such classes in a concurrent environment.
 * </p>
 *
 * <p>Usage:</p>
 * <pre>
 * {@code
 * @NotThreadSafe
 * public class UnsafeCounter {
 *     private int count = 0;
 *
 *     public void increment() {
 *         count++;
 *     }
 *
 *     public int getCount() {
 *         return count;
 *     }
 * }
 * }
 * </pre>
 *
 * <p>Retention policy:</p>
 * The {@code @NotThreadSafe} annotation is retained at runtime, allowing runtime tools
 * to inspect it using reflection.
 *
 * <p>Target:</p>
 * This annotation can only be applied to types (classes, interfaces, enums, etc.).
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {
}
