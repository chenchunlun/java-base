package thread;

/**
 * Created by Administrator on 2016-5-16.
 */
public class StopThread {
    public void test(){
        Study study = new Study();
        new Thread(study).start();
        for(int i = 0;i<1000;i++){
            if(i==100){
                study.stop();
            }
            System.out.println("main....");
        }
    }

}

 class Study implements Runnable{

     private boolean flag = true;

     @Override
     public void run() {
         while (flag){
             System.out.println("测试");
         }
     }

     public void stop(){
         flag = false;
     }
 }
