package cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by mandy on 2016/3/1.
 */
public class CglibTest {
    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new Interceptor());
        Target t = (Target) enhancer.create();
        t.f();
        t.g();
    }


}