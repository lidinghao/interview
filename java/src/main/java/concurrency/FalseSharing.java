package concurrency;

import sun.misc.Contended;

/**
 * Created by mandy on 2016/3/14.
 */
public class FalseSharing implements Runnable {
    private int index;
    private static final int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private static final VolatileLong[] array = new VolatileLong[4];
    static {
        for (int i = 0; i < NUM_THREADS; i++) {
           array[i] = new VolatileLong();
        }
    }
    public final static class VolatileLong
    {
       //
       //@Contended
        public volatile long value = 0L;
    }


    public FalseSharing(int index) {
        this.index = index;

    }
    public void run() {
        long i = ITERATIONS;
        while (0 != --i) {
            array[index].value = i;
        }
    }
}
