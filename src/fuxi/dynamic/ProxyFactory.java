package fuxi.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 它用来生成代理对象
 * 它需要所有参数
 * * 目标对象
 * * 增强
 * Created by 1 on 2017/8/2.
 */
public class ProxyFactory {
    private Object targetObject; //目标对象
    private BeforeAdvice beforeAdvice; //前置增强
    private AfterAdvice afterAdvice; //后置增强

    public Object createProxy() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (ProxyFactory.this.beforeAdvice != null) {
                    ProxyFactory.this.beforeAdvice.before();
                }
                Object result = method.invoke(ProxyFactory.this.targetObject,args);
                if (ProxyFactory.this.afterAdvice != null) {
                    ProxyFactory.this.afterAdvice.after();
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                handler);
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }


    public interface BeforeAdvice {
        public void before();
    }

    public interface AfterAdvice {
        public void after();

    }
}
