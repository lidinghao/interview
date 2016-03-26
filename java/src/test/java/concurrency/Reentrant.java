package concurrency;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mandy on 2016/3/23.
 */
public class Reentrant {
//    public class Lock{
//
//        private boolean isLocked = false;
//
//        public synchronized void lock()
//                throws InterruptedException{
//            while(isLocked){
//                wait();
//            }
//            isLocked = true;
//        }
//
//        public synchronized void unlock(){
//            isLocked = false;
//            notify();
//        }
//    }
    Lock lock = new ReentrantLock(true);

    public synchronized void outer() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "outer");
        inner();
        lock.unlock();
    }

    public synchronized void inner() throws InterruptedException {
        //do something
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "inner");
        lock.unlock();
    }

    @Test
    public void test() throws InterruptedException {
        Runnable run = new Runnable() {
            public void run() {
                try {
                    outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(run);
            thread.setName(String.valueOf(i));
            thread.start();
        }

    }
}
