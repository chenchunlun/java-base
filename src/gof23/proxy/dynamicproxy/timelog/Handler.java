package gof23.proxy.dynamicproxy.timelog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hp on 2016/6/18 0018.
 */
public class Handler<T> implements InvocationHandler {
    private T t;
    public Handler(T t){
        this.t = t;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object rs = method.invoke(t,args);
        long end = System.currentTimeMillis();
        System.out.println(t.getClass().getName()+"."
                +method.getName()+"的执行时间是-->"+((end-start))+"ms");
        return rs;
    }
}
