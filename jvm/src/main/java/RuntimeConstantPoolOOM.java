/**
 * Created by mandy on 2016/3/4.
 */
public class RuntimeConstantPoolOOM {
    public static void test() {
        String str1 = new StringBuilder("计算机").append("技术").toString();
        System.out.println(str1.intern() == str1);

        String str3 = new String("计算机技术");
        System.out.println(str3 == str1.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
