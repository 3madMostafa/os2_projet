package os_problem;
import java.util.List;

class Customer implements Runnable{
    private final List<String> buffer;

    public Customer(List<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true){
            if (buffer.isEmpty()){
                continue;
            }
            if (buffer.get(0).equals(Queue.EOF)){
                System.out.println(Thread.currentThread().getName()+" finished and leaving.");
                break;
            } else {
                System.out.println(Thread.currentThread().getName()+ " Eats Pizza Number " +buffer.remove(0));
            }
        }
    }
}