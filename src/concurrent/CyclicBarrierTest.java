package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class CyclicBarrierTest {
    public static void test(){
        ExecutorService pool = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);
        for(int i=0;i<3;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经有"+(cb.getNumberWaiting()+1)+"个线程到达集合点1");
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("已经有"+(cb.getNumberWaiting()+1)+"个线程到达集合点2");
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
