package task3;

public class Consumer extends Thread {
    private final Supply supply;

    public Consumer(Supply supply) {
        this.supply = supply;
    }

    @Override
    public void run() {
        while (!interrupted() && isAlive()) {
            synchronized (supply) {
                int currentIndex = supply.getCurrentindex();
                if (currentIndex != 0) {
                        supply.decrementIndex();
                        int item = supply.getArr()[currentIndex];
                        System.out.println("Get number " + item);
                        supply.notifyAll();
                } else {
                    try {
                        supply.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
