package fuxi;

import org.junit.Test;

/**
 * Created by 1 on 2017/7/9.
 */
public class TestGender {

    @Test
    public void testGender() {
        Gender man = Gender.MAN;
        System.out.println(man.getValue());
        man = Gender.WOMAN;
        System.out.println(man.getValue());
        for (Gender gender :
                Gender.values()) {
            System.out.println(gender.getName());
        }

    }
}
