package concurrent.traditional;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalTimer {
    private static int count = 0;
    public static void test(){
        class MyTimeTask extends  TimerTask{
            @Override
            public void run() {
                count = (count+1)%2;
                System.out.println("1234");
                new Timer().schedule(new MyTimeTask(),1000+1000*count);
            }
        }
        new Timer().schedule(new MyTimeTask(),1000+1000*count);
    }
}
