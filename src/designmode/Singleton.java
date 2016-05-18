package designmode;

/**
 * Created by Administrator on 2016-5-18.
 */
public class Singleton {
    public static void test(){
        //System.out.println(LazySingleton.newInstance(500));
        //System.out.println(LazySingleton.newInstance(100));
        new TestThread(1000).start();
        new TestThread(50).start();
        new TestThread(30).start();

    }
}

class TestThread extends Thread{
    private long sleep;
    public TestThread(long sleep){
        this.sleep = sleep;
    }
    @Override
    public void run(){
        System.out.println(HungrySingleton.newInstance());
    }
}

/**
 * 饿汉式
 */
class HungrySingleton{
    private static class TestClass {
        private static HungrySingleton INSTANCE = new HungrySingleton();
    }

    //private static HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton newInstance(){
        return TestClass.INSTANCE;
    }
}

/**
 * 懒汉式
 */
class LazySingleton{
    private static LazySingleton INSTANCE;
    private LazySingleton(){}

    public static LazySingleton newInstanceSyn2(long sleep){
        if(null == INSTANCE) {
            synchronized (LazySingleton.class) {
                newInstance(sleep);
            }
        }
        return INSTANCE;
    }

    public static LazySingleton newInstanceSyn1(long sleep){
        synchronized (LazySingleton.class) {
            newInstance(sleep);
        }
        return INSTANCE;
    }

    public synchronized static LazySingleton newInstanceSyn(long sleep){
        return newInstance(sleep);
    }

    public static LazySingleton newInstance(long sleep){
        if(null == INSTANCE){
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static LazySingleton newInstance(){
        if(null == INSTANCE){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}