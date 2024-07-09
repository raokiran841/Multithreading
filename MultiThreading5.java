import java.util.*;

public class MultiThreading5 {

    /*
     * Virtual Threads in java 21 typically have a shallow call stack, performaing as few as 
     * single http client call or single JDBC call.
     * 
     * single JVM might support millons of VT
     * 
     * VTs are not intended for long running CPU intensive operations
     * 
     * VTs can be used for high-throughput application, specially those that consists of
     * a great no of a great no of concurrent tasks that spend much of their time waiting.
     * 
     * VTs are not faster threads, they provide scale not speed.
     */

    public static void main(String[] args) throws InterruptedException {
        // platform thread example
        final int noOfThreads = 10_000;

        List<Thread> listThreads = new ArrayList<>();

        Runnable runnableObj = () -> {
            // simulate API all
            System.out.println("fetching api response ...");
            try{
                Thread.sleep(5000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Data fetched from Api.");
        };

        for(int i=1; i<=noOfThreads; i++){
            // Thread thread = new Thread(runnableObj);
            Thread thread = Thread.ofVirtual().unstarted(runnableObj);
            thread.setName("Thread "+i);
            // thread.setDaemon(true); // by default virtual threads are deamon threads
            thread.start();
            System.out.println("Thread no "+ i);
            listThreads.add(thread);
        }

        for(Thread t: listThreads){
            t.join();
            System.out.println(t.getName()+" Completed");
        }
    }
    
}
