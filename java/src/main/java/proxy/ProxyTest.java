package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by mandy on 2016/3/28.
 */
public class ProxyTest {
    InvocationHandler handler = new MyProxy();
    OrdinaryInterface proxy = ((OrdinaryInterface) Proxy.newProxyInstance(
            OrdinaryInterface.class.getClassLoader(),
            new Class[]{OrdinaryInterface.class}, handler));
}
