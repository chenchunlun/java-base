package reflection;

/**
 * Created by Administrator on 2016-5-27.
 */
public class Test {
    public static void test(){
        String path = "reflection.User";
        try {
            Class<?> clazz = Class.forName(path);
            System.out.println(clazz.toString());
            Class clazz2 = Class.forName(path);
            System.out.println(clazz.hashCode());
            System.out.println(clazz2.hashCode());
            System.out.println(String.class==path.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
