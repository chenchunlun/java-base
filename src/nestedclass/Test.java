package nestedclass;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        Demo2.StaticInnerClass staticInnerClass = new Demo2.StaticInnerClass();
        Demo3 demo3 = new Demo3();
        Demo3.InnerClass innerClass = demo3.new InnerClass();
    }

    // 静态内部类
    private static class StaticNestedClass{

    }

    // 成员内部类
    private class FieldInnerClass{

    }

    // 匿名内部类 成员内部类
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    void sayHello(){
        // 局部内部类
        class LocalClass{

        }

        // 匿名内部类 方法内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
