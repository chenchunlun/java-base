package gof23.factory.abstractFactory;

/**
 * Created by hp on 2016/6/18 0018.
 */
public interface Seat {
    public void massage();
}
class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("可以自动按摩");
    }
}

class LowSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("不能自动按摩");
    }
}
