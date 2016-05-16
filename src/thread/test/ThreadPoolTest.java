package thread.test;

import org.junit.Test;
import thread.ThreadPool;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-16.
 */
public class ThreadPoolTest {
    @Test
    public void threadPool() throws Exception {
        new ThreadPool().threadPool();
    }

}