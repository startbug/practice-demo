package base2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/27 16:58
 */
public class ArrayBlockQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(2);
        queue.add("1");
        queue.add("2");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.take());
    }

}
