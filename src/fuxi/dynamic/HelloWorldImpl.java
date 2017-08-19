package fuxi.dynamic;

/**
 * Created by 1 on 2017/7/23.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    @Override
    public void sayHello(String msg) {
        System.out.println(msg);
    }
}
