package task3;
/*
Напишите многопоточный ограниченный буфер с использованием
synchronized
 */
public class Main {
    public static void main(String[] args) {
        Supply supply = new Supply();
        Producer producer = new Producer(supply);
        Consumer consumer = new Consumer(supply);

        producer.start();
        consumer.start();
    }
}
