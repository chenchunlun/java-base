package gof23;

/**
 * 单例模式.
 * 1个类只有1个对象
 *  提供一个方法  用于访问对象
 *  构造器私有化
 *  提供static 变量 私有
 *  提供开放方法 返回对象
 */
public class Singleton {
    // 类加载时 立即初始化
    // 线程安全 效率高
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return  instance;
    }
}

class SingletonLazy{

}
