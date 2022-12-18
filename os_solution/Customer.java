package os_solution;




public class Customer implements Runnable {
	private final Buffer buffer;
        
	public Customer(Buffer buffer) {
		this.buffer = buffer;
	}

        @Override
	public void run() {
        
            while (true) {
            
            // consume an item from the buffer
            buffer.remove();
           	 
		}
               
	}
        }

        
