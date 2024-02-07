package task1;
/*
Создать три потока Т1, Т2 и Т3
Реализовать выполнение поток в последовательности Т3 -> Т2 -> Т1
(используя метод join)
 */
public class Main {
    public static void main(String[] args) {
        MyThread t3 = new MyThread();
        MyThread t2 = new MyThread(t3);
        MyThread t1 = new MyThread(t2);

        t1.setName("First");
        t2.setName("Second");
        t3.setName("Third");

        t1.start();
        t2.start();
        t3.start();
    }
}
