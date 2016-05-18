package thread;

/**
 * Created by Administrator on 2016-5-18.
 */
public class DeallockThread {
    public static void test(){
        Object goods = new Object();
        Object money = new Object();
        new Thread(new TestThread(goods,money)).start();
        new Thread(new TestThread1(money,goods)).start();
    }
}

class TestThread implements Runnable{
    private Object goods;
    private Object money;

    public TestThread(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized(goods){
            while(true){
                try {
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (money){
                    System.out.println("钱");
                    break;
                }
            }
        }
    }
}

class TestThread1 implements Runnable{
    private Object goods;
    private Object money;
    public TestThread1(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }
    @Override
    public void run() {
        synchronized(money){
            while(true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (goods){
                    System.out.println("货");
                    break;
                }
            }
        }
    }
}
