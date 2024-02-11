package task2;

public class Supply {
    private final int[] arr = new int[10];

    private int currentIndex = 0;

    public int[] getArr() {
        return arr;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void incrementIndex() {
        currentIndex++;
    }

    public  void decrementIndex() {
        currentIndex--;
    }
}
