package concurrent.traditional;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalThreadCommunication {
    public static void test() {
        Bussness bussness = new Bussness();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 50; j++) {
                    bussness.thread(j);
                }
            }
        }).start();

        for (int j = 0; j < 50; j++) {
            bussness.main(j);
        }
    }
}

class Bussness {
    boolean isThread = true;
    public synchronized void thread(int j){
        while(!isThread){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+(j+1)+"次 "+(i+1));
        }
        isThread = false;
        this.notifyAll();
    }

    public synchronized  void main(int j){
        while (isThread){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+(j+1)+"次 "+(i+1));
        }
        isThread = true;
        this.notifyAll();
    }
}
