package thread.test;

import thread.MyThread;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-16.
 */
public class MyThreadTest {
    @org.junit.Test
    public void startThread01() throws Exception {
        new MyThread().startThread01();
        MyThread instance = new MyThread();
        instance.startThread01();

    }

}