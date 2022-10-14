package dev.shtanko.multithreading.concurrent_collections.examples.inventory_manager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager manager = new InventoryManager();
        manager.run(new ArrayList<>()); // ConcurrentModificationException
        System.out.println("Run fixed");
        manager.run(new CopyOnWriteArrayList<>()); // fixed
    }
}
