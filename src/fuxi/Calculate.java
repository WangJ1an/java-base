package fuxi;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2017/7/23.
 */
public class Calculate {
    public int add(int a,int b) {
        return a+b;
    }

    public String echo(String str) {
        return "echo:"+str;
    }


}
