package concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class ReadWriteTest {
    public static void test() {
        final Queue3 queue3 = new Queue3();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        queue3.get();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        queue3.put(new Random().nextInt(10000));
                    }
                }
            }).start();
        }
    }
}

class Queue3 {
    private Object data;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备读");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "已读完");
            lock.readLock().unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(Object data) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写");

            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "已写完");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
}

