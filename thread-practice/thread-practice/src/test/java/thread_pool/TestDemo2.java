package thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 15:35
 */
public class TestDemo2 {

    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
        // 正常执行
//        threadPool.execute(() -> {
//            System.out.println(Thread.currentThread().getName() + ":1");
//        });

        // 延迟执行，执行当前任务延迟5s后再执行
//        threadPool.schedule(() -> {
//            System.out.println(Thread.currentThread().getName() + ":2");
//        }, 5, TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟2s执行，然后每1s执行一次，任务执行开始后，就计算延迟时间
//        threadPool.scheduleAtFixedRate(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(Thread.currentThread().getName() + ":3--" + System.currentTimeMillis());
//        }, 2, 1, TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟2s执行，然后每1s执行一次，任务执行完成后，才开始计算延迟时间
        threadPool.scheduleWithFixedDelay(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":4--" + System.currentTimeMillis());
        }, 2, 1, TimeUnit.SECONDS);

    }

}
