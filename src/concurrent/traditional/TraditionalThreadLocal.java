package concurrent.traditional;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalThreadLocal {

    public static void test() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int temp = (int) (Math.random() * 100000000) + 1;
                    MyThreadScopeData.getInstance().setData(temp);
                    System.out.println(Thread.currentThread().getName() + "放入data--->" + temp);
                    new A().getData();
                    new B().getData();
                }
            }).start();
        }
    }

    static class A {
        public void getData() {
            System.out.println("A: " + Thread.currentThread().getName()
                    + " data -->" + MyThreadScopeData.getInstance().getData());
        }
    }

    static class B {
        public void getData() {
            System.out.println("B: " + Thread.currentThread().getName()
                    + " data -->" + MyThreadScopeData.getInstance().getData());
        }
    }
}

class MyThreadScopeData {

    private MyThreadScopeData() {
    }

    private static ThreadLocal<MyThreadScopeData> threadLocal = new ThreadLocal<>();

    public static MyThreadScopeData getInstance() {
        MyThreadScopeData instance = threadLocal.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            threadLocal.set(instance);
        }
        return instance;
    }

    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}