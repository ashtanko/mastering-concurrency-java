package dev.shtanko.multithreading.interthread_communication;

class FirstUser implements Runnable {
    private final Chat chat;
    private final String[] message = {"Hi", "How are you ?", "I am also doing fine!"};

    public FirstUser(Chat chat) {
        this.chat = chat;
        new Thread(this, "NameT1").start();
    }

    public void run() {
        for (String s : message) {
            chat.ask(s);
        }
    }
}
