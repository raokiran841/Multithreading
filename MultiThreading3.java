import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreading3 {

    public static void main(String[] args) {
        SharedCounter sc = new SharedCounter();

        new Thread(() -> {
            System.out.println("t1 started");
            for(int i=0; i<50000; i++){
                sc.increment();
            }
            System.out.println("t1 completed "+ sc.getCount());
        }).start();

        new Thread(() -> {
            System.out.println("t2 started");
            for(int i=0; i<50000; i++){
                sc.increment();
            }
            System.out.println("t2 completed "+ sc.getCount());
        }).start();
    }
}

class SharedCounter{
    // private int count;
    private AtomicInteger count = new AtomicInteger();

    // public synchronized void increment(){ count++; }
    public void increment(){ count.incrementAndGet(); }

    /*
     * This count++ has 3 instructions
     * get the value of count
     * increament it by 1
     * set the value of count
     * 
     * while executing these 3 steps, another thread can read the older data of count and
     * try to execute the same 3 steps and this causes inconsistency.
     * 
     * this inconsistency can be removed by using Atomic class, or using the increment 
     * method with synchronized keyword.
     */

    // public int getCount() {return count; }
    public int getCount(){ return count.get(); }
}