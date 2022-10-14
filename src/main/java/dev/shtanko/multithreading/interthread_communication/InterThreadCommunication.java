package dev.shtanko.multithreading.interthread_communication;

public class InterThreadCommunication {

    public static void main(String[] args) {
        Chat chat = new Chat();
        new FirstUser(chat);
        new SecondUser(chat);
    }
}
