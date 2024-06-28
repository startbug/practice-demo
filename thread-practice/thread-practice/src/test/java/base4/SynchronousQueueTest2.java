package base4;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 11:10
 */
public class SynchronousQueueTest2 {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue(true);

        new Thread(() -> {
            try {
                queue.put("生1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            System.out.println("消1:" + queue.poll());
        }).start();
        new Thread(() -> {
            System.out.println("消2:" + queue.poll());
        }).start();
        new Thread(() -> {
            System.out.println("消3:" + queue.poll());
        }).start();
    }

}
