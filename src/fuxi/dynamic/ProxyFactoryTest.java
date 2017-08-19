package fuxi.dynamic;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/2.
 */
public class ProxyFactoryTest {

    @Test
    public void fun1() {
        ProxyFactory factory = new ProxyFactory();
        factory.setTargetObject(new ManWaiter());
        factory.setBeforeAdvice(new ProxyFactory.BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("您好");
            }
        });
        factory.setAfterAdvice(new ProxyFactory.AfterAdvice() {
            @Override
            public void after() {
                System.out.println("呵呵");
            }
        });

        Waiter waiter = (Waiter) factory.createProxy();
        waiter.show("Welcome to ShanXi Province");
        waiter.server();
        waiter.shouQian();
    }
}
