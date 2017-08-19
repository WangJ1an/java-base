package fuxi.dynamic;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 1 on 2017/7/23.
 */
public class HelloWorldTest {
    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorldImpl();
        InvocationHandler handler = new HelloWorldHandler(helloWorld);
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                handler);
        proxy.sayHello();
        proxy.sayHello("hahahaha");
    }
}
