package loader;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    static {
        System.out.println("静态初始化Test");
    }

    /**\
     * 主动引用 new A
     * 调用类的静态成员  静态方法
     * 被动引用
     * 调用类的常量
     */
    public static void test() {
//        A a = new A();
//        System.out.println(A.width);
//        A a2 = new A();
        int a = B.width;
       // A[] a = new A[10];
    }
}

/**
 * 栈
 * 执行的方法会被挨个的压栈
 * 堆
 * 形成对象 java.lang.Class 对象  依据class 对象获取
 * 方法区（特殊的堆）
 * 预先加载 类的 运行时数据  静态变量 静态方法 常量池（类名 变量名） 类的代码
 * <p>
 * 处理A   加载A的信息
 */

class A extends A_Father {
    public static int width = 300;
    public static final int max = 123;
    static {
        System.out.println("静态初始化A");
        width = 300;
    }

    public A() {
        System.out.println("创建A的对象");
    }
}

class A_Father extends Object {
    static {
        System.out.println("静态初始化A_Father");
    }
}

class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}