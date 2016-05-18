package thread;

/**
 * Created by Administrator on 2016-5-18.
 */
public class SynThread {
    public static void test() {
        Web12306 web12306 = new Web12306();
        Thread proxy = new Thread(web12306, "黄牛甲");
        Thread proxy1 = new Thread(web12306, "黄牛乙");
        Thread proxy2 = new Thread(web12306, "黄牛丙");
        Thread proxy3 = new Thread(web12306, "黄牛无");
        Thread proxy4 = new Thread(web12306, "黄牛订");
        proxy.start();
        proxy1.start();
        proxy2.start();
        proxy3.start();
        proxy4.start();
    }
}

class Web12306 implements Runnable {

    private int num = 10;

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test5();
            if (num < 1) {
                break;
            }
        }
    }

    public void test5() {
        synchronized (Web12306.class) {
            if (num < 1) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "获取了" + (num--));
        }
    }

    public void test4() {
        synchronized ((Integer)num) {
            if (num < 1) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "获取了" + (num--));
        }
    }

    public void test3(){
        synchronized (obj) {
            if (num < 1) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "获取了" + (num--));
        }
    }

    public void test2() {
        synchronized (this) {
            if (num < 1) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "获取了" + (num--));
        }

    }

    public synchronized void test1() {
        if (num < 1) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + "获取了" + (num--));

    }

    public void test() {
        if (num < 1) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + "获取了" + (num--));
    }
}
