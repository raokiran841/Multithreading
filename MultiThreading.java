public class MultiThreading {

    /**
     * This class shows how we can create threads in java.
     */

    /**
     * when 2 threads try to access data from same memory many issues occur:
     * 1. deadlock
     * 2. race condition
     * 3. congetion
     * etc..
     */

    public static void main(String[] args) {
        System.out.println("MultiThreading class started");

        // METHOD 1
        Thread t1 = new MyThread();
        t1.start();

        // METHOD 2
        Thread t2 = new Thread(() -> {
            System.out.println("lambda thread started");
        });
        t2.start();

        // METHOD 3
        Runnable executable = () -> {
            System.out.println("runnable thread started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable thread completed");
        };
        Thread t3 = new Thread(executable, "runnable-thread");
        t3.setDaemon(true);
        t3.start();
        
        System.out.println("main thread ended");
        
    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println("my thread class started");
    }
}