package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class ThreadPool {
    public static void  test(){
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for(int i = 0;i<10;i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName()+"   " + j+ "--->" + task);
                    }
                }
            });
        }
        threadPool.shutdownNow();

        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时器");
            }
        },10, TimeUnit.SECONDS);
    }
}
