package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016-6-20.
 */
public class CountDownLatchTest {
    public static void test(){
        final CountDownLatch cdl = new CountDownLatch(1);
        final CountDownLatch cd12 = new CountDownLatch(3);
        for(int i = 0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"等待裁判发布信号");
                    try {
                        cdl.await();
                        System.out.println(Thread.currentThread().getName()+"");
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println(Thread.currentThread().getName()+"奔跑结束");
                        cd12.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cdl.countDown();
        System.out.println("裁判发布开始信号");
        try {
            cd12.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运动员全部到达终点");
    }

}
