package nestedclass;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Demo5 {
    public void test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        test02(new Car(){

        });
    }

    public void test02(Car car){
        car.run();
    }

    Car car = new Car(){
        @Override
        public void run() {
            super.run();
        }
    };
}

class Car{
    public  void run(){
        System.out.println("汽车跑");
    }
}
