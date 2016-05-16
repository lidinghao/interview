import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by mandy on 2016/5/16.
 */
public class FinallyTest {
    public static class MyInt {
        public int val = 0;

        public void add() {
            val++;
        }
    }
    public MyInt tryTest() {
        MyInt myInt = new MyInt();
        try {
            myInt.add();
            return myInt;
        }finally {
            myInt.add();
        }
    }

    @Test
    public void test() {
        Class klass = this.getClass();
        for (Method method : klass.getMethods()) {
            System.out.println("kclass: "+method);
        }
        for (Method method : klass.getClass().getMethods()) {
            System.out.println("klass2" + method);
        }
        System.out.println(tryTest().val);
    }
}
