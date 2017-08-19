package fuxi;

import org.junit.Test;

/**
 * Created by 1 on 2017/7/9.
 */
public class Santana implements Car {

    @Override
    public String getName() {
        return "SanTaNa";
    }

    @Override
    public int getPrice() {
        return 100000;
    }
}
