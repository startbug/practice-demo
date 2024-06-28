package base4;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 11:10
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        String msg = "消息";
        //region 生产者添加消息，消费者拉取数据
        new Thread(() -> {
            try {
                System.out.println(queue.offer(msg, 1, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(queue.poll());
        //endregion
    }

}
