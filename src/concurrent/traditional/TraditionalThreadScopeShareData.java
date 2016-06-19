package concurrent.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by hp on 2016/6/19 0019.
 */
public class TraditionalThreadScopeShareData {
    private static Map<String, Integer> map = new HashMap<>();

    public static void test() {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int temp = (int) (Math.random() * 100000000) + 1;
                    map.put(Thread.currentThread().getName(), temp);
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
                    + " data -->" + map.get(Thread.currentThread().getName()));
        }
    }

    static class B {
        public void getData() {
            System.out.println("B: " + Thread.currentThread().getName()
                    + " data -->" + map.get(Thread.currentThread().getName()));
        }
    }


}
