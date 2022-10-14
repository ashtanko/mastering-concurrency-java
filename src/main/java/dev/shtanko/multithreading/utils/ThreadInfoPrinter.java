package dev.shtanko.multithreading.utils;

public final class ThreadInfoPrinter {
    public static void print(Thread thread) {
        String sb = "Thread name: " +
                thread.getName() +
                "\n" +
                "Thread id: " +
                thread.getId() +
                "\n" +
                "Thread priority: " +
                thread.getPriority() +
                "\n" +
                "Thread group name: " +
                thread.getThreadGroup().getName() +
                "\n" +
                "is interrupted: " +
                thread.isInterrupted() +
                "\n" +
                "is alive: " +
                thread.isAlive() +
                "\n" +
                "is daemon: " +
                thread.isDaemon() +
                "\n" +
                "state: " +
                thread.getState() +
                "\n";
        System.out.println(sb);
    }
}
