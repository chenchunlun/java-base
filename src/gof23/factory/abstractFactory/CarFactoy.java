package gof23.factory.abstractFactory;

/**
 * Created by hp on 2016/6/18 0018.
 */
public interface CarFactoy  {
    public Engine createEngine();
    public Seat createSeat();
    public Tyre createTyre();
}

class LuxuryCarFactory implements CarFactoy{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}

class LowCarFactory implements CarFactoy{

    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}

