package concurrency;

import org.junit.Test;

import java.util.Random;

/**
 * Created by mandy on 2016/3/25.
 */
public class TestVisiablity {
    int j = 0;
    final int k = 2000000;
    final int num = 100;
    public void inc() {


            for (int i1 = 0; i1 < k; i1++) {
               synchronized (this){
                    j++;
                }
            }

    }
    @Test
    public void test() throws InterruptedException {
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                   inc();
                }
            });

        }
        for (int i = 0; i < num; i++) {
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(j);
    }
}
