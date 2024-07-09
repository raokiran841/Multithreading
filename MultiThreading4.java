public class MultiThreading4 {
    public static void main(String[] args) {
         ThreadLocal<Long> threadLocal = new ThreadLocal<>();
         
        //  new Thread(() -> {
        //     System.out.println("t1 started");
        //     threadLocal.set(12345L);
        //     System.out.println("t1 local val: "+ threadLocal.get());
        //     threadLocal.remove();
        //     System.out.println("t1 removed val: "+ threadLocal.get());
        //  }).start();

        //  new Thread(() -> {
        //     System.out.println("t2 started");
        //     threadLocal.set(98765L);
        //     System.out.println("t2 local val: "+ threadLocal.get());
        //     threadLocal.remove();
        //     System.out.println("t2 removed val: "+ threadLocal.get());
        //  }).start();

         new Thread(() -> {
            System.out.println("parent t3 started");
            threadLocal.set(10000L);
            System.out.println("parent t3 local val: "+ threadLocal.get());
            
            InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
            inheritableThreadLocal.set("Kiran");
            Thread t4 = new Thread(() -> {
                System.out.println("child t4 started");
                System.out.println("child want parent Tlocal val: "+threadLocal.get());
                System.out.println("child gets parent val with inheritable thread Local: "
                    +inheritableThreadLocal.get());
                // inheritableThreadLocal.remove();
                // System.out.println("child t4 removed inheritableTL val: "+inheritableThreadLocal.get());
                System.out.println("t4 completed");
            });
            t4.start();
            inheritableThreadLocal.remove();
            threadLocal.remove();
            System.out.println("parent t3 removed inheritableTL val: "+inheritableThreadLocal.get());
            // System.out.println("parent t3 wants inheritableTL val: "+inheritableThreadLocal.get());
            System.out.println("parent t3 removed val: "+ threadLocal.get());
         }).start();
    }
}
