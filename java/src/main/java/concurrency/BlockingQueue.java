package concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mandy on 2016/3/8.
 */
public class BlockingQueue<T> {
    private final int limit;
    private final Queue<T> queue;

    public BlockingQueue(int limit) {
        this.limit = limit;
        this.queue = new  LinkedList();
    }
    public synchronized void  put(T e) throws InterruptedException {
        if (queue.size() == limit) wait();
        this.queue.add(e);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        if (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {

            notifyAll();
        }
        return queue.remove();
    }
}
