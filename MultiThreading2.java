public class MultiThreading2 {

    /**
     * In this class we see the use of volatile keyword and sychronized keyword
     * to overcome visibility problem.
     */

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        // thread 1
        new Thread(() -> {
            System.out.println("t1 started");
            try {
                System.out.println("t1 logic started");
                Thread.sleep(2000);
                System.out.println("t1 logic completed");
                resource.setFlag(true);
                System.out.println("flag set by t1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("t2 logic started");
            while(!resource.getFlag()){
                // this will keep on going until flag value is read by thread2
            }
            System.out.println("t2 logic completed");
        }).start();
        
        System.out.println("main thread ended");
        
    }
}

class SharedResource{
    private volatile boolean flag;
    /*
     * when the flag is not set as volatile then value set by t1 in memory is not read by t2.
     * t2 will keep on reading from cache the old data.
     * volatile keyword tells t2 to read from memory directly and not the cache. 
     * Hence it gets the latest data.
     * 
     * This is called visibility problem.
     */

     /*
      * Another way to solve this problem is by setting the getter and setter methods as synchronized.
      */

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean val){
        flag = val;
    }
}