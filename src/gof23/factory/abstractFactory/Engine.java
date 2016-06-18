package gof23.factory.abstractFactory;

/**
 * Created by hp on 2016/6/18 0018.
 */
public interface Engine {
    public void run();
    public void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转的快");
    }

    @Override
    public void start() {
        System.out.println("启动快");
    }
}


class LowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转的慢");
    }

    @Override
    public void start() {
        System.out.println("启动慢");
    }
}
