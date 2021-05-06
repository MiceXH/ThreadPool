package exc;

import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerThread extends Thread {
    private ArrayBlockingQueue queue;
    public ConsumerThread(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("准备消费");
        int taskNum;
        try {
            taskNum = (int)queue.take();
            System.out.println("消费了" + taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
