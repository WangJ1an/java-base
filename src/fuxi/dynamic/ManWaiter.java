package fuxi.dynamic;

/**
 * Created by 1 on 2017/8/2.
 */
public class ManWaiter implements Waiter {
    @Override
    public void server() {
        System.out.println("服务中.......");
    }

    @Override
    public void show(String str) {
        System.out.println(str);
    }

    @Override
    public void shouQian() {
        System.out.println("狗似滴，掏钱");
    }
}
