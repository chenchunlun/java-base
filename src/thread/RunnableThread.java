package thread;

/**
 * Created by Administrator on 2016-5-16.
 */
public class RunnableThread {
    public void runnableThread (){
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<1000;i++){
                    System.out.println("乌龟在爬");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<1000;i++){
                    System.out.println("兔子在跑---------------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
