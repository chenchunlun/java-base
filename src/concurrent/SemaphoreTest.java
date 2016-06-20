package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class SemaphoreTest {
    public static void test(){
        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);
        for(int i = 0;i<10;i++){
           pool.execute(new Runnable() {
               @Override
               public void run() {
                   try {
                       sp.acquire();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+"已经进入，"
                           +(3-sp.availablePermits())+"个线程拿到了灯");
                   try {
                       Thread.sleep((long)(Math.random()*10000));
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+"即将离开");
                   sp.release();
                   System.out.println(Thread.currentThread().getName()+"已经离开，"
                           +(3-sp.availablePermits())+"个线程拿到了灯");
               }
           });
        }
    }
}
