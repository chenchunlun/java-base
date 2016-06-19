package concurrent.traditional;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalThreadMultiShareData {
    public static void test() {
        ShareData shareData = new ShareData();
        new Thread(new MyRunnable(shareData)).start();
        new Thread(new MyRunnable(shareData)).start();
    }
}

class MyRunnable implements Runnable{
    ShareData data ;
    MyRunnable(ShareData data){
        this.data = data;
    }
    @Override
    public void run() {

    }
}

class ShareData /*implements Runnable*/ {
    private int j = 0;
    public synchronized void increment(){
        j++;
    }

    public synchronized void decrement(){
        j--;
    }


}
