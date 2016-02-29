package random.patternmatching;

import java.util.Random;

/**
 * Created by mandy on 2015/11/30.
 */
public class PrimeNumberGenerator {
    public static int generate(int max){
        Random rand = new Random();
        int i = rand.nextInt(max);
        while (!isPrime(i))
            i = rand.nextInt(max);
        return i;


    }
    public static boolean isPrime(int num){
        if(num <= 3||num%2==0)
            return num ==2||num==3;

        double x = Math.sqrt(num);
        for(int divisor = 3;divisor <= x; divisor += 2){
                if (num % divisor ==0)
                   return false;
                }
        return true;
    }
}
