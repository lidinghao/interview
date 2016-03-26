package concurrency;

/**
 * Created by mandy on 2016/3/23.
 */
public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();
        private Integer integer = new Integer("1");

        public void run() {
            synchronized(this){

            }
            threadLocal.set((int) (Math.random() * 100D));
            integer += (int) (Math.random() * 100D);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println("threadLocal:" + threadLocal.get());
            System.out.println("non-threadLocal:"+ integer);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}


