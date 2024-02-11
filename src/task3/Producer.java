package task3;

public class Producer extends Thread{

    private final Supply supply;

    public Producer(Supply supply) {
        this.supply = supply;
    }

    public void run() {
        while (!interrupted() && isAlive()) {
            synchronized (supply) {
                int currentIndex = supply.getCurrentIndex();
                int[] arr = supply.getArr();
                if (currentIndex != supply.getArr().length - 1) {
                        arr[currentIndex] = (int) (Math.random() * 20);
                        supply.incrementIndex();
                        System.out.println("add number " + arr[currentIndex]);
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
