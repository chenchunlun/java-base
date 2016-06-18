package gof23.proxy.dynamicproxy.timelog;

import java.lang.reflect.Proxy;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        Runnable test = (Runnable) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Runnable.class},
                new Handler<Runnable>(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(Long.parseLong("100"));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }));

            test.equals(null);

    }
}
