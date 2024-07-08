package concurrent_tool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/6 14:54
 */
public class TestDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);

        new Thread(() -> {
            System.out.println("获取三个资源");
            try {
                semaphore.acquire(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release(3);
                System.out.println("释放三个资源");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        for (int i = 1; i <= 10; i++) {
            final int fi = i;
            new Thread(() -> {
                System.out.println("鱼塘" + fi + "号鱼获取1个资源");
                try {
                    semaphore.acquire(1);
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release(1);
                    System.out.println("鱼塘" + fi + "号鱼释放1个资源");
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(6);

        if (semaphore.tryAcquire()) {
            System.out.println("最后一个游客拿到资源");
            semaphore.release();
        } else {
            System.out.println("最后一个游客拿不到资源_GGG~~~");
        }


    }

}
