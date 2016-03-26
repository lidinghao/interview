import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by mandy on 2016/2/22.
 */
public class PlayGround {
    @Test
    public void playGround() throws IOException {
        System.out.println("Enter the input");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = bufferedReader.readLine();

        System.out.println(s);
        HashMap<Integer,String> hashMap = new HashMap();
        hashMap.put(null, null);
        hashMap.put(null,"string");
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get(null));
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
        hashtable.put(123, null);


        //Scanner scanner = new Scanner(System.in);


//        List<? super Number> foo1 = new ArrayList<Integer>();

        List<? super Integer> foo2 = new ArrayList<Number>();
        List<? extends Integer> foo3 = new ArrayList<Integer>();

        int[][] array =  new int[3][2];
        System.out.println("row nums: " + array[0].length );
        System.out.println("column nums: " + array.length );

    }
    int x ;
    public synchronized void Foo(int k) {
        x = (++k);
    }
    public void test() {
        synchronized(this) {
            x++;
        }
    }
}
