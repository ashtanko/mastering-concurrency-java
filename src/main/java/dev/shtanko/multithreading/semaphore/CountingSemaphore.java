package dev.shtanko.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountingSemaphore {

    public static void main(String[] args) {
        final int threadCount = 6;
        final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
        final Library library = new Library();
        for (int i = 0; i < threadCount; i++) {
            Reader reader = new Reader(library);
            exService.execute(reader);
        }
        exService.shutdown();
    }

    public static class Library {
        private static final int MAX_PERMIT = 3;
        private final Semaphore availableBook = new Semaphore(MAX_PERMIT, true);
        private final Book[] books = {
                new Book("Ramayan"),
                new Book("Mahabharat"),
                new Book("Panchtantra")
        };
        private final boolean[] beingRead = new boolean[MAX_PERMIT];

        //Book is being issued to reader
        public Object issueBook() throws InterruptedException {
            availableBook.acquire();
            return getNextAvailableBook();
        }

        private synchronized Book getNextAvailableBook() {
            Book book = null;
            for (int i = 0; i < MAX_PERMIT; ++i) {
                if (!beingRead[i]) {
                    beingRead[i] = true;
                    book = books[i];
                    System.out.println(book.bookName() + " has been issued.");
                    break;
                }
            }
            return book;
        }

        //Book is being returned to library
        public void returnBook(Book book) {
            if (markAsAvailableBook(book))
                availableBook.release();
        }

        private synchronized boolean markAsAvailableBook(Book book) {
            boolean flag = false;
            for (int i = 0; i < MAX_PERMIT; ++i) {
                if (book == books[i]) {
                    if (beingRead[i]) {
                        beingRead[i] = false;
                        flag = true;
                        System.out.println(book.bookName() + " has been returned.");
                    }
                    break;
                }
            }
            return flag;
        }
    }

    public static class Reader implements Runnable {
        private final Library library;

        public Reader(Library library) {
            this.library = library;
        }

        @Override
        public void run() {
            try {
                Book book = (Book) library.issueBook();
                book.read();
                library.returnBook(book);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public record Book(String bookName) {
        public void read() {
            System.out.println(bookName + " is being read......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
