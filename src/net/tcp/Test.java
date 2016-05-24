package net.tcp;

/**
 * Created by hp on 2016/5/24 0024.
 */
public class Test {
    public static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server.test();
            }
        },"server:").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client.test();
            }
        },"client:").start();
    }
}
