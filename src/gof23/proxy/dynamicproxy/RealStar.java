package gof23.proxy.dynamicproxy;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("real star  confer");
    }


    @Override
    public void signcontract() {
        System.out.println("real star singcontract ");
    }

    @Override
    public void bookTicket() {
        System.out.println("real star  bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("real star sing ");
    }

    @Override
    public void collectMoney() {
        System.out.println("real star collectMoney ");
    }
}
