package fuxi;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2017/7/23.
 */
public class TestReflect {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object object = new Calculate();
        Class classType = object.getClass();

        Object ca = classType.newInstance();
        Method echo = classType.getMethod("echo", String.class);
        Method add = classType.getMethod("add", int.class, int.class);
        Object echoValue = echo.invoke(ca,"hahaha");
        Object addValue = add.invoke(ca,1,2);
        System.out.println(echoValue.toString());
        System.out.println(addValue);

    }

}
