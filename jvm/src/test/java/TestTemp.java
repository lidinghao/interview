import org.junit.Test;

/**
 * Created by mandy on 2016/3/17.
 */
public class TestTemp {
    @Test
    public void test() {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            //那么开始回答问题，JAVA和C#这种语言比起C/C++来说，虚化了内存地址的概念，所以这个问题就完全停留在单纯的语言解释层面了。不妨把JAVA看作一门脚本语言，然后就是一个evaluation顺序的问题了。
//            例子1和3中的 j = j++;
//            j会先执行等号右边的表达式
//            第一次执行：
//            j++后j为1，该表达式返回值是加之前j的值也就是返回0
//                    然后执行=运算符
//            将右边表达式的返回值赋值给左边的变量。
//            j<-0
//            最终j的结果是0
//

            j=j++;
            //能写出j==j++，看来j++是表达式
            if (j==j++) {
                System.out.println(j);
            }
        }

    }
}
