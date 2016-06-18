package gof23.proxy.staticproxy;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star){
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("proxy star  confer");
    }


    @Override
    public void signcontract() {
        System.out.println("proxy star singcontract ");
    }

    @Override
    public void bookTicket() {
        System.out.println("proxy star  bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("proxy star sing ");
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("proxy star collectMoney ");
    }
}
