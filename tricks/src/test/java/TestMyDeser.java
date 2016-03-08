import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mandy on 2016/3/4.
 */
public class TestMyDeser {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = ForTest.class;
        Method[] methods = clazz.getMethods();
        Constructor[] constructors = clazz.getConstructors();
        ForTest  forTest = new ForTest(3);
        for (Constructor ctor : constructors) {
            if (ctor.getAnnotation(MyDeser.class) != null) {
                Class[] paras = ctor.getParameterTypes();
                for (Class para : paras) {
                    MyDeserField  annotation = ((MyDeserField) para.getAnnotation(MyDeserField.class));
                    if (annotation != null) {
                        String str = annotation.value();

                    }
                    if (para == int.class) {

                     forTest = (ForTest) clazz.getConstructor(int.class).newInstance(1);
                    }
                }
            }


        }
        System.out.println(forTest.field);
    }
}
