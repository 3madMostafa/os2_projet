package os_solution;
 



public class main {
    
    
    public static void main(String[] args) throws InterruptedException {
       
        
        
        Buffer  bufer = new Buffer();
        // now create the producer and consumer threads
        Thread producer = new Thread(new Baker(bufer));
        Thread consumer = new Thread(new Customer(bufer));
        
        Thread producer2 = new Thread(new Baker(bufer));
        Thread consumer2 = new Thread(new Customer(bufer));
        Thread consumer3 = new Thread(new Customer(bufer));

        
       
        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();
        //consumer3.start();
        
        producer.join();
        producer2.join();
        consumer.join();
        consumer2.join();
        //consumer3.join();
        
        
    }
}

