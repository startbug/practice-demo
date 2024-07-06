package concurrent_tool;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/6 11:57
 */
public class TestDemo1 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("本次处理已完成");
        });

        new Thread(() -> {
            System.out.println("活动1开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                System.out.println("活动1完蛋");
                return;
            }
            System.out.println("活动1结束");
        }).start();

        Thread t2 = new Thread(() -> {
            System.out.println("活动2开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                System.out.println("活动2完蛋");
                return;
            }
            System.out.println("活动2结束");
        });
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();

        new Thread(() -> {
            System.out.println("活动3开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                System.out.println("活动3完蛋");
                return;
            }
            System.out.println("活动3结束");
        }).start();

        Thread.sleep(2000);

        System.out.println("==================================================");
        // 被中断之后，必须要reset，否则执行会抛出异常
//        cyclicBarrier.reset();
        new Thread(() -> {
            System.out.println("活动1开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("活动1结束");
        }).start();

        new Thread(() -> {
            System.out.println("活动2开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("活动2结束");
        }).start();

        new Thread(() -> {
            System.out.println("活动3开始");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("活动3结束");
        }).start();


    }

}
