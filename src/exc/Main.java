package exc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
        //为多生产者和多消费者分别开创的线程池
        ThreadPoolExecutor productPool =
                new ThreadPoolExecutor(10, 20, 60, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolExecutor consumerPool=
                new ThreadPoolExecutor(10, 20, 60, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        System.out.println("start");
        for (int i = 0; i < 100; ++i) {
            productPool.execute(new ProductThread(i, queue));
            consumerPool.execute(new ConsumerThread(queue));
        }
        productPool.shutdown();
        consumerPool.shutdown();
    }
}
