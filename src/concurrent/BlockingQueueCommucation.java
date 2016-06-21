package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hp on 2016/6/20 0020.
 */
public class BlockingQueueCommucation {
    public static void test() {
        final Bussness bussness = new Bussness(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    bussness.print(1);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    bussness.print(2);
                }
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            bussness.print(0);
        }
    }

    static class Bussness {
        int index;
        BlockingQueue[] queues;

        Bussness(int count) {
            queues = new BlockingQueue[count];
            for (int i = 0; i < queues.length; i++) {
                queues[i] = new ArrayBlockingQueue(1);
                try {
                    queues[i].put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queues[0].take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void print(int index) {
            try {
                queues[index].put(new Object());
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "   " + (i + 1));
                }
                this.index = (index + 1) % queues.length;
                queues[this.index].take();
            } catch (Exception e) {
            }
        }
    }
}

