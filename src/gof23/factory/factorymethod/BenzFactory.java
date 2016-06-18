package gof23.factory.factorymethod;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
