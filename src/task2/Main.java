package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
Напишите многопоточный ограниченный буфер с использованием
ReentrantLock
 */
public class Main {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition newCondition = lock.newCondition();

        Supply supply = new Supply();
        Producer producer = new Producer(supply, lock, newCondition);
        Consumer consumer = new Consumer(supply, lock, newCondition);

        producer.start();
        consumer.start();
    }
}
