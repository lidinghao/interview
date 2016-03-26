package collection;

/**
 * Created by mandy on 2016/3/22.
 */
public class B extends A {
    public int m = method3();
    public static int n = method4();
    public int t = 0;
    public B() {
        System.out.println(4);
    }

    public int method3() {
        System.out.println(5);
        return 5;

    }
    public static int method4() {
        System.out.println(6);
        return 6;

    }

    public static void main(String[] args) {
        System.out.println(7);
        A a = new B();
    }
}
