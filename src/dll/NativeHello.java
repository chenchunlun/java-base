package dll;


/***
 * 1、创建含有native方法的类
 * 2、编译生成该类的class
 * 3、(bin目录下) java -classpath . -jni 类全名  生成头文件
 * 4、编写cpp文件（包含3生成的头文件） 实现native方法
 * 5、拷贝jdk目录中的jni.h和jni_md.h 到cpp文件所在目录
 * 6、执行cll命令，得到dll文件 cl/LD cpp文件绝对路径  得到nativeHelloImpl.dll文件 把dll文件拷贝到C:\Windows\System32
 */
public class NativeHello {
    static {
        System.loadLibrary("nativeHelloImpl");
    }
    public native void nativeRealize();
    public static void test(){
        new NativeHello().nativeRealize();
    }
}
