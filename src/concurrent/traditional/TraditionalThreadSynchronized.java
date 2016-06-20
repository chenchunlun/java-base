package concurrent.traditional;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalThreadSynchronized {
    public static void test() {
        final OutPut outPut = new OutPut();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("wiupoweterntlhre");
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("哈哈哈哈哈哈");
                }

            }
        }).start();
    }


}

class OutPut {
    String iii = "";
    public synchronized void outPut(String name) {
        synchronized (this) {
            for (char c : name.toCharArray()) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
