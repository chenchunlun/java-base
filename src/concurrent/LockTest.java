package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class LockTest {
    public static void test() {
        OutPut1 outPut = new OutPut1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("wiupoweterntlhre");
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("哈哈哈哈哈哈");
                }

            }
        }).start();
    }


}

class OutPut1 {
    Lock lock = new ReentrantLock();

    public void outPut(String name) {
        lock.lock();
        try {
            for (char c : name.toCharArray()) {
                System.out.print(c);
            }
            System.out.println();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
