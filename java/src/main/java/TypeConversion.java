import org.junit.Test;

/**
 * Created by lihao on 16/5/4.
 */
public class TypeConversion {
    @Test
    public void test() {
        short myshort = 99;
        //系统默认的浮点数为double,下句编译不通过
        //float z = 1.0;
        float z = 1.0f;
        int l = 075;
        System.out.println(l);
        short s = 1;
        s += 1;
    }

    public void testException() throws XXException {
        throw new XXException();
    }

    public class XXException extends Exception {

    }

}
