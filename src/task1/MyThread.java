package task1;
import java.lang.Thread;

public class MyThread extends Thread {
    private Thread thread;

    public MyThread(Thread thread) {
        this.thread = thread;
    }

    public MyThread() {}

    @Override
    public void run() {
        try {
            if(thread != null) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        printNum();
    }

    public void printNum() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
