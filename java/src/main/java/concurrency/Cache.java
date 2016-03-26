package concurrency;

import javafx.util.Pair;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mandy on 2016/3/8.
 */
public class Cache<K,V> {

    private final static Logger LOG = Logger.getLogger(Cache.class.getName());
    ConcurrentMap<K, V> cacheMap = new ConcurrentHashMap();
    DelayQueue<DelayedItem<Pair<K,V>>> queue= new DelayQueue();
    Thread daemonThread;
    public Cache() {
        final Runnable daemonTask = new Runnable() {
            public void run() {
                daemonCheck();
            }
        };
        daemonThread = new Thread(daemonTask);
        daemonThread.setDaemon(true);
        daemonThread.setName("concurrency.Cache Daemon");
        daemonThread.start();
    }

    private void daemonCheck() {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "cache daemon started");
        }
        for (;;) {
            try {
                DelayedItem<Pair<K, V>> delayedItem = queue.take();
                if (delayedItem != null) {
                    Pair<K, V> item = delayedItem.getItem();
                    cacheMap.remove(item.getKey(), item.getValue());
                }
            } catch (InterruptedException e) {
                if (LOG.isLoggable(Level.SEVERE)) {
                    LOG.log(Level.SEVERE, e.getMessage(), e);
                }
                e.printStackTrace();
                break;
            }

        }
        if (LOG.isLoggable(Level.INFO)) {
            LOG.log(Level.INFO, "cache daemon stoped");
        }
    }
    
    public void put(K key, V value, long time, TimeUnit timeUnit) {
        V oldValue = cacheMap.put(key, value);
        if (oldValue != null) {
            queue.remove(key);
        }
        long nanoTime = TimeUnit.NANOSECONDS.convert(time,timeUnit);
        queue.put(new DelayedItem<Pair<K, V>>(new Pair<K,V>(key, value), nanoTime));

    }
    public V get(K key) {
        return cacheMap.get(key);
    }

}
