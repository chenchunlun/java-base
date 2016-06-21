package concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by hp on 2016/6/20 0020.
 */
public class ArrayBlockingQueueTest {
    public static void test(){
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("准备放数据");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arrayBlockingQueue.offer("");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("准备取数据 还剩"+arrayBlockingQueue.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        arrayBlockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
