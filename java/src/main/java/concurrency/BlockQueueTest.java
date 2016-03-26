package concurrency;

import org.junit.Test;

/**
 * Created by mandy on 2016/3/8.
 */
public class BlockQueueTest {
    BlockingQueue queue = new BlockingQueue(2);
    Producer producer = new Producer(queue);
     Consumer consumer = new Consumer(queue);
    @Test
    public void test() {
        new Thread(new Producer(queue)).start() ;
        new Thread(new Consumer(queue)).start();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public class Producer implements Runnable {
        private final BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put("1");

                queue.put("2");

                queue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class Consumer implements Runnable {
        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {

            try {
                System.out.println(queue.take());
                Thread.sleep(1000);
                System.out.println(queue.take());
                Thread.sleep(1000);
                System.out.println(queue.take());
                Thread.sleep(1000);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
