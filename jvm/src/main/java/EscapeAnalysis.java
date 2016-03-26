/**
 * Created by mandy on 2016/3/16.
 */
//http://blog.csdn.net/yangzl2008/article/details/43202969
public class EscapeAnalysis {
    private static class Foo {
        private int x;
        private static int counter;

        public Foo(int k) {
            x = (++k);
        }
    }
    public static void main(String[] args){
        long start = System.nanoTime();
       int k;
        for (int i = 0; i < 1000 * 1000 * 10; ++i) {
            k = i +2;
            Foo foo = new Foo(k);
        }
        long end = System.nanoTime();
        System.out.println("Time cost is " + (end - start));
    }
}
