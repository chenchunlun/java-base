package thread.test;

import org.junit.Test;
import thread.YieldThread;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-17.
 */
public class YieldThreadTest {
    @Test
    public void yieldThread() throws Exception {
        new YieldThread().yieldThread();
    }

}