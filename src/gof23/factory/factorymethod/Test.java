package gof23.factory.factorymethod;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Test {
    public static void test(){
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();
        c1.run();
        c2.run();

        Car c3 = new BenzFactory().createCar();
        c3.run();
    }

}
