package gof23.factory.abstractFactory;

/**
 * Created by hp on 2016/6/18 0018.
 */
public interface Tyre {
    public void revolve();
}


class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("旋转的快");
    }
}

class LowTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("旋转的慢");
    }
}