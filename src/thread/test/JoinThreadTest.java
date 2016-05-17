package thread.test;

import org.junit.Test;
import thread.JoinThread;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-17.
 */
public class JoinThreadTest {
    @Test
    public void joinThread() throws Exception {
        new JoinThread().joinThread();
    }

}