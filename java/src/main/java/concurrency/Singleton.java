package concurrency;

/**
 * Created by mandy on 2016/3/26.
 */
public class Singleton {
    private volatile static Singleton _instance;
    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

}
