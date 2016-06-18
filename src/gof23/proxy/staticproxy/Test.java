package gof23.proxy.staticproxy;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        ProxyStar proxyStar = new ProxyStar(new RealStar());
        proxyStar.sing();
    }
}
