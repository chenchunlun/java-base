package concurrent.traditional;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class TraditionalThread {
    public static void test(){
        java.lang.Thread thread = new java.lang.Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        java.lang.Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(java.lang.Thread.currentThread().getName());
                }
            }
        };
        thread.start();

        new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        java.lang.Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(java.lang.Thread.currentThread().getName());
                }
            }
        }).start();

        new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    while (true){
                        try {
                            java.lang.Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Runnable-->"+ java.lang.Thread.currentThread().getName());
                    }
                }
            }
        }){
            @Override
            public void run(){
                while(true){
                    while (true){
                        try {
                            java.lang.Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread-->"+ java.lang.Thread.currentThread().getName());
                    }
                }
            }
        }.start();
    }
}
