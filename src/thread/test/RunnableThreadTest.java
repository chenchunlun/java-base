package thread.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import thread.RunnableThread;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-16.
 */
public class RunnableThreadTest {
    @Before
    public void setUp() throws Exception {
       // System.out.println("测试执行之前.....");
    }

    @After
    public void tearDown() throws Exception {
       // System.out.println("测试执行之后.....");
    }

    @Test
    public void runnableThread() throws Exception {
        new RunnableThread().runnableThread();
    }

}