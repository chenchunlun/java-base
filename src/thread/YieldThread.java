package thread;

/**
 * Created by Administrator on 2016-5-17.
 */
public class YieldThread {
    public void yieldThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<100;i++){
                    System.out.println("thread------>"+i);
                }
            }
        }).start();

        for(int i = 0;i<100;i++){
            if(50==i){
                Thread.yield();
            }
            System.out.println("main------>"+i);
        }

    }
}
