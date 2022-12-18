package os_solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class Buffer {
    
    public static final int BUFFER_SIZE = 7;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;
    Queue<Integer> buffer;
  
    
    
    
    public Buffer() {
        this.buffer = new LinkedList<>();
        
        mutex = new Semaphore(1); //to determine who is going to take the shared resources or enter the buffer
        empty = new Semaphore(BUFFER_SIZE); //to define the empty space in the buffer
        full = new Semaphore(0); //to determine the space that is filled by the producer
    }
    
     int i=1;
     
     
      public void insert(){
         while(true){ 
              if(buffer.size()<BUFFER_SIZE){
            try{
            
             empty.acquire(); //hold the empty space in the buffer
             mutex.acquire(); //hold the resources for one process
        // add an item to the buffer
        
            buffer.add(i);
           
            System.out.println("store still not full Serve a customer Num "+i+".\n" );
            System.out.println("There are = "+buffer.size()+" Tables in use now.\n");
            i++;
           
            mutex.release(); //allow other processes to take advantage of the resources
            full.release(); //allow other processes to know the filled places in the buffer
                }
                
            catch(InterruptedException e){
                  System.out.println("Process get interrupted");
                      }
              }
              else{
            System.out.println("Store is Full, Please wait..\n");
        }
        }
        }
      
        public int remove() { 
        while(true){  
            if(buffer.size()>=1){
            try{
        full.acquire(); //to hold the space filled by the producer so we can remove it
        mutex.acquire(); //hold the resources for one process
        
        int item = buffer.remove();
        
        System.out.println("Customer "+item+" Finished his/her meal and left.\n");
        System.out.println("There are = "+buffer.size()+" Tables in use now.\n");
        
        mutex.release(); //allow other processes to take advantage of the resources
        empty.release(); //empty space in the buffer to the other processes
        
        //return item;
        }
            catch(InterruptedException e){
                  System.out.println("Process get interrupted");
     

              }
            }
            else{
            System.out.println("Store is Empty, No customers to serve waiting..\n");
        }
            
        }
        
        
            }
       
        } 
    
    

