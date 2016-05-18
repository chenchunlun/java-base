package designmode;

/**
 * Created by Administrator on 2016-5-18.
 */
public class ProducerConsumer {
    private static final ShareData BUFF = new ShareData();

    public static void test() {
        // 生产者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int product = (int) (Math.random() * 1000) + 1;
                    BUFF.setData(product);
                    try {
                        Thread.sleep((long) (Math.random() * 500) + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 消费者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    BUFF.getData();
                    try {
                        Thread.sleep((long) (Math.random() * 500) + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static class ShareData {
        // 缓冲区
        private static int[] SHARE_ARRAY = new int[10];
        private int count;
        private int in;
        private int out;

        private void setData(int product) {
            synchronized (this) {
                try {
                    while (count>=SHARE_ARRAY.length) {
                        System.out.println("缓冲区已满");
                        this.wait();
                    }
                    this.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SHARE_ARRAY[in] = product;
                count++;
                in = (in + 1) % SHARE_ARRAY.length;
                System.out.println("生产：" + product);
            }
        }

        private void getData() {
            synchronized (this) {
                try {
                    while (count <= 0) {
                        System.out.println("缓冲区是空的");
                        this.wait();
                    }
                    this.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int product = SHARE_ARRAY[out];
                count--;
                out = (out + 1) % SHARE_ARRAY.length;
                System.err.println("取出：" + product);
            }
        }
    }
}
