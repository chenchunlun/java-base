package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class CallableAndFuture {
    public static void test() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<String> rs = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });
        try {
            System.out.println(rs.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService(pool2);
        for (int i = 0; i < 10; i++) {
            final int sequence = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(500));
                    return sequence + 1;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        pool2.shutdown();
    }
}
