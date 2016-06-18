package nestedclass;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Demo2 {
    int c = 5;
    static int d = 10;
    void ttt(){
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
    public static class StaticInnerClass {
        int a = 3;
        static int b = 5;
        public void test(){
            System.out.println(d);
        }
    }
}

