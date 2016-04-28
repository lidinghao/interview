import org.junit.Test;

import java.util.HashSet;

/**
 * Created by mandy on 2016/4/28.
 */
public class BitwiseOperator {

    @Test
    public void testShortCircuit(){
        int array[] = new int[]{1,2,3};
        int i = 0;
        //这里不会发生数组越界
        while(i < array.length && array[i] != 4){
            i++;
        }

        i = 0;
        //这里会发生数组越界
        while(i < array.length & array[i] != 4){
            i++;
        }

    }
}
