package task3;

public class Supply {
    private int[] arr = new int[10];

    private int currentindex = 0;

    public int[] getArr() {
        return arr;
    }

    public int getCurrentindex() {
        return currentindex;
    }

    public void incrementIndex() {
        currentindex++;
    }

    public  void decrementIndex() {
        currentindex--;
    }
}
