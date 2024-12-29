package dev.shtanko.multithreading;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to indicate that a field or method is guarded by a specific lock.
 * <p>
 * The {@code @GuardedBy} annotation is used to document which lock is used to protect access
 * to the annotated field or method. This helps developers ensure thread safety by specifying
 * the synchronization mechanism that should be held when accessing the annotated element.
 * </p>
 *
 * <p>The {@code value} specifies the lock that guards the annotated element. Common values include:</p>
 * <ul>
 *   <li>{@code this}: The intrinsic lock of the current instance.</li>
 *   <li>{@code class-name.this}: The intrinsic lock of a specific outer instance.</li>
 *   <li>{@code class-name.class}: The intrinsic lock of the class object.</li>
 *   <li>{@code field-name}: A specific lock object referenced by the field.</li>
 * </ul>
 *
 * <p>Usage:</p>
 * <pre>
 * {@code
 * public class Example {
 *
 *     private final Object lock = new Object();
 *
 *     @GuardedBy("lock")
 *     private int sharedResource;
 *
 *     @GuardedBy("this")
 *     public synchronized void updateResource() {
 *         sharedResource++;
 *     }
 *
 *     public void safeAccess() {
 *         synchronized (lock) {
 *             // Access sharedResource
 *         }
 *     }
 * }
 * }
 * </pre>
 *
 * <p>Retention policy:</p>
 * The {@code @GuardedBy} annotation is retained in the class file but is not available at runtime.
 *
 * <p>Target:</p>
 * This annotation can be applied to fields and methods.
 *
 * @param value the name of the lock that guards the annotated field or method
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GuardedBy {
    String value();
}
