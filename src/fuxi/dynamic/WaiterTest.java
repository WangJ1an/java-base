package fuxi.dynamic;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 1 on 2017/8/2.
 */
public class WaiterTest {
    @Test
    public void fun1() {
        Waiter manWaiter = new ManWaiter();
        InvocationHandler handler = new WaiterInvocationHandler(manWaiter);

        //得到代理对象，代理对象就是在目标对象基础上进行了增强的对象
        Waiter waiter = (Waiter) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Waiter.class},
                handler);
        waiter.server();
        waiter.show("hahaha");
    }

    private class WaiterInvocationHandler implements InvocationHandler {
        private Waiter waiter;

        public WaiterInvocationHandler(Waiter waiter) {
            this.waiter = waiter;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("你好");
            method.invoke(waiter,args);
            System.out.println("再见");
            return null;
        }
    }
}
