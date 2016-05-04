import org.junit.Test;

import java.util.Objects;

/**
 * Created by mandy on 2016/3/28.
 */
public class TestNotify {
    private final  static int NUM_THREADS = 5;

    public class RunAndWait implements Runnable {
        private final int id;
        public RunAndWait(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            synchronized (RunAndWait.class) {
                try {
                    System.out.println("thread: " + id + " enter");
                    Thread.sleep(100);
                   // RunAndWait.class.wait();
                    System.out.println("thread: " + id + " wake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS ; i++) {
            threads[i] = new Thread(new RunAndWait(i));
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();


        }
        synchronized (RunAndWait.class) {

            RunAndWait.class.notify();
            RunAndWait.class.notify();
            RunAndWait.class.notify();
            RunAndWait.class.notify();
            RunAndWait.class.notify();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

    }
}
