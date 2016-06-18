package loader;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    static {
        //System.out.println("静态初始化Test");
    }

    /**
     * \
     * 主动引用 new A
     * 调用类的静态成员  静态方法
     * 被动引用
     * 调用类的常量
     */
    public static void test() {
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("F:");
        FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader("F:");

        try {
            Class<?> c = fileSystemClassLoader.loadClass("test");
            Class<?> c1 = fileSystemClassLoader2.loadClass("test");
            System.out.println(c.hashCode());
            System.out.println(c1.hashCode());
            Class<?> c3 = fileSystemClassLoader2.loadClass("test");
            System.out.println(c3.getClassLoader());
            System.out.println(fileSystemClassLoader2.loadClass("java.lang.String").getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void demo() {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        String a = "gaogao";
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);
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

class B extends A {
    static {
        System.out.println("静态初始化B");
    }
}