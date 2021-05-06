package exc;

import java.util.concurrent.ArrayBlockingQueue;

public class ProductThread extends Thread{
    private int taskNum;
    private ArrayBlockingQueue queue;

    public ProductThread(int taskNum, ArrayBlockingQueue queue) {
        this.taskNum = taskNum;
        this.queue = queue;
    }

    public void run() {
        try {
            //模拟生产
            Thread.currentThread().sleep(5000);
            System.out.println("开始生产");
            queue.add(taskNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
