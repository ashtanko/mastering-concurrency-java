package dev.shtanko.multithreading.concurrent_collections.examples.inventory_manager;

import java.util.List;

public class InventoryManager {

    public void run(List<Product> products) throws InterruptedException {
        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                populateSoldProducts(products);
            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                displaySoldProducts(products);
            }
        });

        inventoryTask.start();
        Thread.sleep(2000L);
        displayTask.start();
    }

    private void populateSoldProducts(List<Product> products) {
        for (int i = 0; i < 1000; i++) {
            Product product = new Product(i, "test_product_" + i);
            products.add(product);
            System.out.println("ADDED: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void displaySoldProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println("PRINTING THE SOLD: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
