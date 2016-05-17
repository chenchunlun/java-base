package thread.test;

import org.junit.Test;
import thread.CountDown;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-5-17.
 */
public class CountDownTest {
    @Test
    public void countDown() throws Exception {
        new CountDown().countDown();
    }

}