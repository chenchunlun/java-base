package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-5-17.
 */
public class CountDown {
    public void countDown(){
        final DateFormat sdf = new SimpleDateFormat("mm:ss");
        Date endTime = new Date(System.currentTimeMillis()+10*1000);
        long endTimeData = endTime.getTime();
        System.out.println("**********************************************");
        while(true) {
            System.out.println(sdf.format(endTime.getTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endTime = new Date(endTime.getTime()-1000);
            if(endTimeData<endTime.getTime()){
                break;
            }
        }
    }
}
