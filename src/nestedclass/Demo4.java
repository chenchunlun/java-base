package nestedclass;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Demo4 {
   // int a = 3;
    public void test(){
        final int a = 3;
        class Inner{
            int b = 10;
            void test(){
                System.out.println(a);
            }
        }

        Inner i = new Inner();
    }
}
