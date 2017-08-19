package fuxi.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 1 on 2017/8/2.
 */
public interface Waiter {
    public void server();
    public void show(String str);
    public void shouQian();
}

