package gof23.factory.simplefactory;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        Car c1 = CarFactory.createCar("奥迪");//new Audi();
        Car c2 = CarFactory.createCar("比亚迪");new Byd();
        c1.run();
        c2.run();
    }

}
