package MaximumFlow;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by mandy on 2015/12/7.
 */

public class FordFulkersonTest {
    @Before
    public void setUp(){

    }
    @Test
    public  void testScanner() {

        InputStream in = this.getClass().getResourceAsStream("Tiny.txt");
        Scanner scanner = new Scanner(in);
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
    }
    @Test
    public void testFordFulkerson(){
        InputStream in = this.getClass().getResourceAsStream("Tiny.txt");
        Scanner scanner = new Scanner(in);
       // FordFulkerson ff  =  new FordFulkerson();

    }
}