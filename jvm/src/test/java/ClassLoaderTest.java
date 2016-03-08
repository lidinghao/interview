import org.junit.Test;

/**
 * Created by mandy on 2016/3/4.
 */
public class ClassLoaderTest {
    class Some {

    }
    @Test
    public void testClassLoader() {
        Some some = new Some();

        Class clazz = some.getClass();
        ClassLoader loader = clazz.getClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

    }

}
