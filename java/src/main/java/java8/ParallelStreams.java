package java8; /**
 * Created by mandy on 2016/4/8.
 */

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by mandy on 2015/8/28.
 */
public class ParallelStreams {
    public static long iterativeSum(long n){
        long acc = 0;
        for(long i = 1L;i<= n; i++){
            acc += i;
        }
        return acc;
    }
    public static long sequentialSum(long n){
        return Stream.iterate(1L, i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }
    public static long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long sideEffectSum(long n){
        Accumulator acc = new Accumulator();
        LongStream.rangeClosed(1L,n)
                .parallel()
                .forEach(acc::add);
        return acc.total;
    }
    public static  long measureSumPerformence(Function<Long,Long> adder, long n){
        long fastest = Long.MAX_VALUE;
        for(int i =0;i<10;i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long end = System.nanoTime();
            long duration = (end - start)/1_000_000;
            System.out.println("Result: " + sum);
            if(duration < fastest) fastest = duration;


        }
        return fastest;
    }
    @Test
    public  void test() {
        System.out.println("Sequential sum done in: "+
                measureSumPerformence(ParallelStreams::sequentialSum, 10_000_000)+ "msecs");

       System.out.println("Iterative sum done in: "+
                measureSumPerformence(ParallelStreams::iterativeSum, 10_000_000)+ "msecs");

       System.out.println("Parallel sum done in: "+
                measureSumPerformence(ParallelStreams::parallelSum, 10_000_000)+ "msecs");

      System.out.println("ranged sum done in: "+
               measureSumPerformence(ParallelStreams::rangedSum, 10_000_000)+ "msecs");

        System.out.println("Parallel ranged sum done in: "+
                measureSumPerformence(ParallelStreams::parallelRangedSum, 10_000_000)+ "msecs");

        System.out.println("Side effect sum done in: "+
               measureSumPerformence(ParallelStreams::sideEffectSum, 10_000_000)+ "msecs");

        // write your code here
    }
    // str has been sorted.

}
