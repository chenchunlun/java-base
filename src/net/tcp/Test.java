package net.tcp;

/**
 * Created by hp on 2016/5/24 0024.
 */
public class Test {
    public static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                net.tcp.chat_room.Server.test();
            }
        },"Server:").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                net.tcp.chat_room.Client.test();
            }
        },"用户1:").start();
    }
}
