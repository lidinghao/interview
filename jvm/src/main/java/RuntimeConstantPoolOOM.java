import org.junit.Test;

/**
 * Created by mandy on 2016/3/4.
 */
public class RuntimeConstantPoolOOM {
    @Test
    public  void test() {
        String str1 = new StringBuilder("计算机").append("技术").toString();
        System.out.println(str1.intern() == str1);
        str1 =null;
        System.gc();

        String str3 = new String("计算机技术");
        //此时输出仍然为false,证明垃圾回收并没有移走str1指向的对象,
        // 说明了常量池中引用的对象为GC root
        System.out.println(str3 == str3.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
