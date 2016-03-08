import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by mandy on 2016/3/7.
 */
public class TestCollection {
    @Test
    public void test() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(2);
        foreach(hashSet);
        foreach(new ArrayList());
    }
    public void foreach(Collection elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }
}
