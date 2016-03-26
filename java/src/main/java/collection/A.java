package collection;

/**
 * Created by mandy on 2016/3/22.
 */
public class A {
    public int i = method();
    public static int j = method2();
    public int k = 0;

    public A() {
        System.out.println(1);
    }
    public int method() {
        System.out.println(2);
        return 2;
    }

    public static int method2() {
        System.out.println(3);
        return 3;
    }
}
