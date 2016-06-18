package gof23.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                ,new Class[]{Star.class},new StarHandler(new RealStar()));
        proxy.bookTicket();
    }
}
