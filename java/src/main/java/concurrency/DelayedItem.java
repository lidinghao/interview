package concurrency;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mandy on 2016/3/9.
 */
public class DelayedItem<T> implements Delayed {

    private static final long NANO_EPOCH = System.nanoTime();
    private final long time;

    private static final AtomicLong sequencer = new AtomicLong(0);
    private final T item;
    private final long seqNum;

    /** The time that the task is enabled to execute in nanoTime units */
    private static long now() {
        //avoid auto boxing / wrapping increase the num is too big
        return System.nanoTime() - NANO_EPOCH;
    }

    public T getItem() {
        return item;
    }

    public DelayedItem(T t, long timeout) {
        this.time = now() + timeout;
        this.item = t;
        this.seqNum = sequencer.incrementAndGet();
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - now(), TimeUnit.NANOSECONDS);
    }

    public int compareTo(Delayed other) {
        if (other== this)
            return 0;
        if (other instanceof DelayedItem) {
            DelayedItem x = ((DelayedItem) other);
            long diff = this.time - x.time;
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                if (seqNum > x.seqNum) return 1;
                else return -1;
            }
        }
        long d = getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
        return d == 0 ? 0 : ((d > 0) ? 1 : -1);

    }
}