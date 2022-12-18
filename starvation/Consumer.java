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
    //Consumer Class
public class Consumer implements Runnable {
    private BoundedBuffer buffer;
 
    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
          while (true) {                
                int item = buffer.remove();
            }
//            System.out.println("i am her");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
