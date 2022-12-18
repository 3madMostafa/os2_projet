package os_problem;

import java.util.ArrayList;
import java.util.List;


public class Queue {
    public static final String EOF = "EOF";
    public static void main(String[] args) throws InterruptedException {
        List<String> buffer = new ArrayList<>();

        Thread producerThread1 = new Thread(new Baker(buffer));
        producerThread1.setName("Baker");
        
        Thread producerThread2 = new Thread(new Baker(buffer));
        producerThread2.setName("Baker");
        
        Thread producerThread3 = new Thread(new Baker(buffer));
        producerThread3.setName("Baker");

        Thread consumerThread1 = new Thread(new Customer(buffer));
        consumerThread1.setName("Customer 1");

        Thread consumerThread2 = new Thread(new Customer(buffer));
        consumerThread2.setName("Customer 2");
        
        Thread consumerThread3 = new Thread(new Customer(buffer));
        consumerThread2.setName("Customer 3");

        producerThread1.start();
        consumerThread2.start();
        producerThread3.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        
        producerThread1.join();
        consumerThread2.join();
        producerThread3.join();
        consumerThread1.join();
        consumerThread2.join();
        consumerThread3.join();
    }
}