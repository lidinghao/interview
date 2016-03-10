import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2016/3/9.
 */
public class CacheTest {

    @Test
    public void testPut() throws Exception {
        Cache<Integer, String> cache = new Cache();
        Thread.sleep(2000);
        cache.put(1, "abc", 3, TimeUnit.SECONDS);
        System.out.println(cache.get(1));
        Thread.sleep(4000);
        System.out.println(cache.get(1));
    }

    @Test
    public void testGet() throws Exception {

    }
}