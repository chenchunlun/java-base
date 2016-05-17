package thread;

/**
 * Created by hp on 2016/5/18 0018.
 */
public class StatusThread {
    public void test(){
        ThreadSatus t = new ThreadSatus();
        Thread thread = new Thread(t);
        thread.setPriority(Thread.MAX_PRIORITY);
        ThreadSatus t1 = new ThreadSatus();
        Thread thread1 = new Thread(t1);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.setName("机会");
        thread.start();
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stop();
        t1.stop();
        /*thread.setName("测试线程");
        System.out.println("关闭前状态"+thread.isAlive());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stop();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("关闭后状态"+thread.isAlive());*/
    }
}

class ThreadSatus implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"----->"+i++);
        }
    }
    public void stop (){
        flag = false;
    }
}
