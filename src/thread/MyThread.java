package thread;

/**
 * 多线程
 */
public class MyThread {
   public void startThread01(){
        new Turtle().start();
        new Rabbit().start();
    }
}

/**
 * 乌龟线程
 */
class Turtle extends Thread {
    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println("乌龟爬");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Rabbit extends Thread{
    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println("兔子跑-----------");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}