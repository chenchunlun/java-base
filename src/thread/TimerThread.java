package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016-5-18.
 */
public class TimerThread {
    public static void test(){
        Timer timer = new Timer();
        final DateFormat df = new SimpleDateFormat("hh:mm:ss");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(df.format(new Date()));
            }
        },new Date(System.currentTimeMillis()+5*1000),1000);
    }
}
