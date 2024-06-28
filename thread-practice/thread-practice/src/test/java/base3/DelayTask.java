package base3;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 10:04
 */
public class DelayTask {

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task("A", 1000L);
        Task task2 = new Task("B", 5000L);
        Task task3 = new Task("C", 3000L);
        Task task4 = new Task("D", 2000L);

        DelayQueue<Task> queue = new DelayQueue<>();
        queue.offer(task1);
        queue.offer(task2);
        queue.offer(task3);
        queue.offer(task4);

        // A D C B
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

}
