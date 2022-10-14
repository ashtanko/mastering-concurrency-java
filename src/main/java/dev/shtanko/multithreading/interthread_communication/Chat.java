package dev.shtanko.multithreading.interthread_communication;

class Chat {
    boolean isLocked = false;

    public synchronized void ask(String msg) {
        if (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        isLocked = true;
        notify();
    }

    public synchronized void answer(String msg) {
        if (!isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        isLocked = false;
        notify();
    }
}
