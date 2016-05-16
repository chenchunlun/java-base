package thread;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016-5-16.
 */
public class ThreadPool {
    public void threadPool() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future future = pool.submit(new Callable<Object>() {
            @Override
            public String call() throws Exception {
                return "测试";
            }
        });
        Future future2 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        System.out.println(future.get());
        System.out.println(future2.get());
        pool.shutdownNow();
    }
}
