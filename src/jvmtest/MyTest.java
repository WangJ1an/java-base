package jvmtest;




/**
 * Created by 1 on 2017/8/7.
 */
public class MyTest {

    public static void main(String[] args) {


    }



}
class Singleton {
    private static Singleton singleton = new Singleton();

    public static int counter1;
    public static int counter2 = 0;

    private Singleton() {
        counter1++;
        counter2++;
    }


    public static Singleton getInstance() {
        return singleton;
    }

}
