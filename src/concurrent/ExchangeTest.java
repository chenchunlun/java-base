package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016-6-20.
 */
public class ExchangeTest {
    public static void test(){
        ExecutorService pool = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "毒粉";
                System.out.println(Thread.currentThread().getName()+"交出数据-->"+data1);
                try {
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println(Thread.currentThread().getName()+"取回数据-->"+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "人民币";
                System.out.println(Thread.currentThread().getName()+"交出数据-->"+data1);
                try {
                    Thread.sleep((long)(Math.random()*1000));
                    String data2 = exchanger.exchange(data1);
                    System.out.println(Thread.currentThread().getName()+"取回数据-->"+data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        pool.shutdown();
    }
}
