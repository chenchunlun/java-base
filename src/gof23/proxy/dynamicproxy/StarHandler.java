package gof23.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class StarHandler implements InvocationHandler{

    private Star star;

    public StarHandler(Star star) {
        this.star = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法调用之前");
        //System.out.println(proxy);
        Object rs = method.invoke(star,args);
        System.out.println("代理方法调用之后");
        return rs;
    }
}
