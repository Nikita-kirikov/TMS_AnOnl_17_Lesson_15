package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer extends Thread {
    private final Supply supply;
    private final ReentrantLock lock;
    private final Condition condition;

    public Consumer(Supply supply, ReentrantLock lock, Condition condition) {
        this.supply = supply;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (!interrupted() && isAlive()) {
            lock.lock();
            try {
                int currentIndex = supply.getCurrentIndex();
                if (currentIndex != 0) {
                    supply.decrementIndex();
                    int item = supply.getArr()[currentIndex];
                    System.out.println("Get number " + item);
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
