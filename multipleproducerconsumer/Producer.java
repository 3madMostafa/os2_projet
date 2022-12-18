/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleproducerconsumer;

//Producer Class:

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private BoundedBuffer buffer;
    private int item;
    
    public Producer(BoundedBuffer buffer, int item) {
        this.buffer = buffer;
        this.item = item;
    }
    
    public void run() {
        try {
            buffer.insert(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
