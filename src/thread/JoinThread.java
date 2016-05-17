package thread;

/**
 * Created by Administrator on 2016-5-17.
 */
public class JoinThread {

    public void joinThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<1000;i++){
                    System.out.println("thread------>"+i);
                }
            }
        });
        thread.start();

        for(int i = 0;i<1000;i++){
            if(500==i){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main------>"+i);
        }
    }

}
