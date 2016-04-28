import org.junit.Test;

/**
 * Created by mandy on 2016/4/8.
 */
public class PrimaryTypes {
    @Test
    public void test() {
        Integer i1 = -129;
        Integer i2 = -129;
        int i3 = 3;
        System.out.println(i1 == i2);
        //System.out.println(i2 == i3);
    }
@Test
    public void test2() {
    int x = 2015;
    int count = 0;
    while (x > 0) {
        count++;
        x = x & (x - 1);
        System.out.println(x);
    }
    System.out.println(count);
}

}
