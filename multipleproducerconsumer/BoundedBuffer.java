package multipleproducerconsumer;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    private int[] buffer;
    private int capacity;
    private int front;
    private int rear;
    private int count;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
    
    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = 0;
        count = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(capacity);
        full = new Semaphore(0);
    }
    
    public void insert(int item) throws InterruptedException {
         try {
                if (count >= capacity) {

                }else{
                    empty.acquire();
                    mutex.acquire();
                    buffer[rear] = item;
                    rear = (rear + 1) % capacity;
                    count++;

                    mutex.release();
                    full.release();
                } 
            } catch (Exception e) {
                System.out.println("null");
            }
    }
    
    public int remove() throws InterruptedException {
        if (count > 0){
                try {
                    full.acquire();
                    mutex.acquire();
                    int item = buffer[front];
                    front = (front + 1) % capacity;
                    count--;

                    mutex.release();
                    empty.release();
                    return item;     
            } catch (Exception e) {

                }
            }else{ 
 
                    return 0;
                }
        return 0;
    }
    public Semaphore getMutex(){
        return mutex;
    }
    public Semaphore getEmpty(){
        return empty;
    }
    public Semaphore getFull(){
        return full;
    }
    public int getCounter(){
        return count;
    }
    public int getBufferSize(){
        return capacity;
    }
}