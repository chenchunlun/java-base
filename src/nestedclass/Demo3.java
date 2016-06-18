package nestedclass;

import java.util.Date;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Demo3 {
    private int a = 3;
    private int b = 10;
    void tttt(){
        InnerClass innerClass = new InnerClass();
    }
    public class InnerClass{
        static final int a = 3 ;
        // static final  Date dfa = new Date();
        void test(){
            System.out.println(a);
            System.out.println(this);
            System.out.println(Demo3.this);
        }
    }
}
