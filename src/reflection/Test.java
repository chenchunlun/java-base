package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016-5-27.
 */
public class Test {
    public static void test(){
        String path = "reflection.User";
        try {
            Class<?> clazz = Class.forName(path);
            //User user = (User)clazz.newInstance();// 实际上是调用无参构造方法
            Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User user = (User)c.newInstance(1001,18,"姓名");
            Method m = clazz.getDeclaredMethod("setUname",String.class);
            m.invoke(user,"呵呵");

            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true);
            f.set(user,"嘿嘿");
            System.out.println(user);
            // 获取类的名字
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());
            // 获取属性
            Field[] fields = clazz.getFields();
            fields = clazz.getDeclaredFields();
            System.out.println(fields.length);
            for(Field field:fields){
                System.out.println(field.toString());
            }

            // 获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method method1 = clazz.getDeclaredMethod("getUname",null);
            Method method2 = clazz.getDeclaredMethod("setUname",String.class);
            for(Method method:methods){
                System.out.println(method);
            }

            // 获取构造器
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }
            Constructor constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println(constructor);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
