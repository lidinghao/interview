import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mandy on 2016/3/7.
 */
public class VolatileTest {
    public static AtomicInteger  race = new AtomicInteger(0);
    public static void inc() {
        race.incrementAndGet();
    }
    private static final int THREADS_COUNT = 20;
    @Test
    public  void test() {
        Thread[] threads = new Thread[THREADS_COUNT];
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch stopSignal = new CountDownLatch(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        startSignal.await();
                        for (int j = 0; j < 10000; j++) {
                            inc();
                        }
                        stopSignal.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            threads[i].start();
        }
        //using CountDownLatch to wait all threads to terminate
        startSignal.countDown();
        try {
            stopSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //using join to wait all threads to terminate

//        for (int i = 0; i < THREADS_COUNT; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }

        Thread[] th = new Thread[Thread.activeCount()];
        Thread.enumerate(th);
        for (Thread thread : th) {
            System.out.println(thread.getName());
        }

//       while (Thread.activeCount() > 1) {
//
//            Thread.yield();
//        }

        System.out.println(Thread.activeCount());

        System.out.println(race);
    }
}
