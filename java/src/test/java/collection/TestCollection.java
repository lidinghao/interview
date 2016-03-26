package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by mandy on 2016/3/7.
 */
public class TestCollection {
    private class Tiny {
        int x;
        int y;
    }
    @Test
    public void test() {
        HashSet<Tiny> hashSet = new HashSet<Tiny>();
        Tiny  tiny = new Tiny();
        tiny.x = 1;
        tiny.y = 2;

        hashSet.add(tiny);
        tiny.x = 3;

//        for (Tiny tiny1 : hashSet) {
//            tiny1.x = 3;
//        }
        for (Tiny tiny1 : hashSet) {
            System.out.println(tiny1.x);
        }

       // foreach(hashSet);
       // foreach(new ArrayList());
    }
    public void foreach(Collection elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }
}
