/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starvation;

/**
 *
 * @author MBR
 */
//Producer Class
public class Producer implements Runnable {
    private BoundedBuffer buffer;
    private int item;
 
    public Producer(BoundedBuffer buffer, int item) {
        this.buffer = buffer;
        this.item = item;
    }
 
    @Override
    public void run() {
        try {
              while (true) {                
                buffer.insert(item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
