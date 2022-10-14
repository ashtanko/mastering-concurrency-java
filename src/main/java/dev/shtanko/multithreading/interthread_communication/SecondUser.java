package dev.shtanko.multithreading.interthread_communication;

class SecondUser implements Runnable {
    private final Chat chat;
    private final String[] message = {"Hi", "I am good, what about you?", "Great!"};

    public SecondUser(Chat chat) {
        this.chat = chat;
        new Thread(this, "NameT2").start();
    }

    public void run() {
        for (String s : message) {
            chat.answer(s);
        }
    }
}
