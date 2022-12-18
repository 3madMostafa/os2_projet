/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author MBR
 */
public class Testv4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer(9);
        
        Producer producer = new Producer(buffer, 1);
        Consumer consumer = new Consumer(buffer);
        Producer producer1 = new Producer(buffer, 3);
        Producer producer2 = new Producer(buffer, 2);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        
        Thread producerThread = new Thread(producer );
        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        Thread consumerThread = new Thread(consumer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        
       
       
         consumerThread.start();
          producerThread1.start();
          consumerThread2.start();
        producerThread.start();
       
        consumerThread1.start();
        producerThread2.start();
        
        

        

//        BoundedBuffer  Buffer = new BoundedBuffer(2);
//        Thread producer = new Thread(new Producer(Buffer, 9));
//        Thread producer1 = new Thread(new Producer(Buffer, 3));
//        Thread producer2 = new Thread(new Producer(Buffer, 4));
//        Thread consumer = new Thread(new Consumer(Buffer));
//        consumer.start();
//        producer.start();
//        producer2.start();
//        producer1.start();  

    }
    
}



