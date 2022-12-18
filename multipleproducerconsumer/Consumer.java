/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleproducerconsumer;

//Consumer Class:

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private BoundedBuffer buffer;
    private static int value;
    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        try {
            value = buffer.remove();
            setItem(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void setItem(int item){
        value = item;
    }

    public int getItem(){
        return value;
    }
    
}