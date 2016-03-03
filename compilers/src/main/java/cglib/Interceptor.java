package cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by mandy on 2016/3/1.
 */
public class Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + "I am intercept begin");
        methodProxy.invokeSuper(obj, objects);
        System.out.println(method.getName() + "I am intercept end");
        return null;
    }
}
