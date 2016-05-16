package designmode;

/**
 * 静态代理设计模式
 * 代理对象和非代理对象需要实现同一个接口
 */
public class StaticProxy {
    public void test(){
        new MarryCompany(new People()).marry();
    }
}


interface Marry{
    void marry();
}

class People implements Marry{

    @Override
    public void marry() {
        System.out.println("张三和李四搞基，最终走进了婚姻的殿堂");
    }
}

class MarryCompany implements Marry{

    private Marry marry;

    public MarryCompany(Marry marry) {
        this.marry = marry;
    }

    private void before (){
        System.out.println("两人结婚之前，代理公司做准备工作");
    }

    private void after(){
        System.out.println("两人结婚之后，代理公司做收尾工作");
    }


    @Override
    public void marry() {
        before();
        marry.marry();
        after();
    }
}
