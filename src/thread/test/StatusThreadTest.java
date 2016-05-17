package thread.test;

import thread.StatusThread;

import static org.junit.Assert.*;

/**
 * Created by hp on 2016/5/18 0018.
 */
public class StatusThreadTest {

    @org.junit.Test
    public void testTest1() throws Exception {
        new StatusThread().test();
    }
}