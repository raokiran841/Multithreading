import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreading7 {

    /*
     * ThreadPoolExecutor in java.
     */

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
            1,
            5,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(2)
        );
        
        for(int i=1; i<=5; i++){
            final int taskId = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thread pool executor "+
                "Thread task "+ taskId +
                " executed by thread "+ Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    } 
}
