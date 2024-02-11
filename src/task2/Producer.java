package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer extends Thread{
    private final Supply supply;
    private final ReentrantLock lock;
    private final Condition condition;

    public Producer(Supply supply, ReentrantLock lock, Condition condition) {
        this.supply = supply;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        while (!interrupted() && isAlive()) {
            lock.lock();
            try {
                int currentIndex = supply.getCurrentIndex();
                int[] arr = supply.getArr();
                if (currentIndex != supply.getArr().length - 1) {
                    arr[currentIndex] = (int) (Math.random() * 20);
                    supply.incrementIndex();
                    System.out.println("add number " + arr[currentIndex]);
                    condition.signal();
                } else {
                    condition.await();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
