package fuxi.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2017/7/23.
 */
public class HelloWorldHandler implements InvocationHandler {
    private Object obj;

    public HelloWorldHandler(Object obj) {
        this.obj = obj;
    }

    private void doBefore() {
        System.out.println("before method invoke");
    }

    private void doAfter() {
        System.out.println("after method invoke");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        doBefore();
        result = method.invoke(obj,args);
        doAfter();
        return result;
    }
}
