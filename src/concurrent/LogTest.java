package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016-6-21.
 */
public class LogTest {
    public static void test() {
       // final Semaphore semaphore  = new Semaphore(1);
        final Lock lock = new ReentrantLock() ;
        final SynchronousQueue<String> queue = new SynchronousQueue<>();
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));

        for(int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        //semaphore.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    lock.lock();
                    String input = null;
                    try {
                        input = queue.take();
                        System.out.println(Thread.currentThread().getName() + ":" + doSome(input));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                    //semaphore.release();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            String input = i + "";
            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
        for(int i = 0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String log = blockingQueue.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i = 0;i<16;i++){
            final String log = (i+1)+"";
            try {
                blockingQueue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    private static void parseLog(String log) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(log + ":" + (System.currentTimeMillis() / 1000));
    }

    private static String doSome(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input + ":" + (System.currentTimeMillis() / 1000);
    }
}
