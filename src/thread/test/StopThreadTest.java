package thread.test;

import org.junit.Test;
import thread.StopThread;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-16.
 */
public class StopThreadTest {
    @Test
    public void test1() throws Exception {
        new StopThread().test();
    }

}