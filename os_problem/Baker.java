package os_problem;
import java.util.ArrayList;
import java.util.List;


class Baker implements Runnable{
    private List<String> buffer;

    public Baker(List<String> buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        String numbers[] = {"1","2","3"};
        while(buffer.size()<3){
        for (String number : numbers){
            buffer.add(number);
            System.out.println(Thread.currentThread().getName()+" Baked Pizza Number "+number);
        }
        System.out.println(Thread.currentThread().getName()+" Says No more customers. "+Queue.EOF);
        buffer.add(Queue.EOF);
        }
    }
}