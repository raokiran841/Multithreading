import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreading6 {

    /*
     * Java Executor service :- high level concurrency utility that provides a way to manage and
     * execute tasks Asychronuously in a pool of threads.
     * Executor service abstracts away the complexity of thread management.
     * 
     * Diff types:
     * 1. Single Thread Executor
     * 2. Fixed Thread Executor
     * 3. Cached Thread Executor
     * 4. Scheduled Thread Executor
     * 
     */

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Single thread executor.");
        for(int i=1; i<=5; i++){
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single thread task "+ taskId + 
                " executed by thread "+ Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();

        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);
        System.out.println("Fixed thread executor.");
        for(int i=1; i<=5; i++){
            final int taskId = i;
            fixedThreadExecutor.execute(() -> {
                System.out.println("Fixed thread task "+ taskId + 
                " executed by thread "+ Thread.currentThread().getName());
            });
        }
        fixedThreadExecutor.shutdown();

        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        System.out.println("Cached thread executor.");
        for(int i=1; i<=5; i++){
            final int taskId = i;
            cachedThreadExecutor.execute(() -> {
                System.out.println("Cached thread task "+ taskId + 
                " executed by thread "+ Thread.currentThread().getName());
            });
        }
        cachedThreadExecutor.shutdown();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("Scheduled thread executor.");
        for(int i=1; i<=5; i++){
            final int taskId = i;
            scheduledThreadPool.schedule(() -> {
                System.out.println("Scheduled thread task "+ taskId + 
                " executed by thread "+ Thread.currentThread().getName());
            }, 3, TimeUnit.SECONDS);
        }
        scheduledThreadPool.shutdown();
    }
    
}
