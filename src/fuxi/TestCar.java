package fuxi;

import org.junit.Test;

/**
 * Created by 1 on 2017/7/9.
 */
public class TestCar {
    @Test
    public void testCar() {
        CarShop carShop = new CarShop();
        Car BMW = new BMW();
        Car CheryQQ = new CheryQQ();
        Car Santana = new Santana();
        carShop.sellCar(BMW);
        carShop.sellCar(CheryQQ);
        carShop.sellCar(Santana);
        System.out.println(carShop.getMoney()) ;
    }
}
