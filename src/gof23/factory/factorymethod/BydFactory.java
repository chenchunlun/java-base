package gof23.factory.factorymethod;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
