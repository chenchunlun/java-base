package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class ConditionCommunication {
    public static void test() {
        Bussness bussness = new Bussness(3);
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
}

class Bussness {
    Lock lock;
    int index;
    Condition[] conditions;

    Bussness(int count) {
        lock = new ReentrantLock();
        conditions = new Condition[count];
        for (int i = 0; i < conditions.length; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public void print(int index) {
        lock.lock();
        try {
            while (this.index != index) {
                conditions[index].await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "   " + (i + 1));
            }
            this.index = (index + 1) % conditions.length;
            conditions[this.index].signal();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}
