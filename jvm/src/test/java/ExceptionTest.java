/**
 * Created by mandy on 2016/3/11.
 */
public class ExceptionTest {
    void test1() throws Exception {
        throw new Exception("");

    }
    void test2() throws Exception {
        test1();
    }
    void test3() throws Exception {
        try {
            test2();
        }finally {
            int x = 6;
        }
    }
}
