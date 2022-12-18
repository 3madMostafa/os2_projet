/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

import java.util.concurrent.Semaphore;

/**
 *
 * @author MBR
 */
    //Bounded Buffer Class
public class BoundedBuffer {
    private int[] buffer;
    private int capacity;
    private int size;
    private int front;
    private int rear;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
 
    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(capacity);
        full = new Semaphore(0);
    }
 
    public void insert(int item) throws InterruptedException {
        while(true){
            try {
                if (size > capacity) {
                    System.out.println("Buffer is Full" + " ID: "+ Thread.currentThread().getId());
                }else{
                    empty.acquire();                    
                     mutex.acquire();
                   
                    buffer[rear] = item;
                    rear = (rear + 1) % capacity;
                    size++;
                    System.out.println(item +" was added, buffer length = " + size + " ID: "+ Thread.currentThread().getId());
                    mutex.release();
                    full.release();
                    
                } 
            } catch (Exception e) {
                System.out.println("null");
            }
        }
            
    }
 
    public int remove() throws InterruptedException {
        while(true){
            if (size > 0){
                try {
                    mutex.acquire();
                    full.acquire();
                    
                    int item = buffer[front];
                    front = (front + 1) % capacity;
                    size--;
                    System.out.println("Consumer consumed an item = " + item +", buffer length = " + size + " ID: "+ Thread.currentThread().getId());
                     empty.release();
                    mutex.release();
                   
                    return item;     
            } catch (Exception e) {
                System.out.println("null");
                }
            }else{ 
                    System.out.println("Buffer is Empty"+ " ID: "+ Thread.currentThread().getId());
                    return 0;
                }
        return 0;
        }
    }
}
