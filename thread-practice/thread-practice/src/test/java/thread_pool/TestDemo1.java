package thread_pool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 15:20
 */
public class TestDemo1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        newThreadPool();
        System.gc();
        Thread.sleep(5000);
        System.out.println("线程池回收");
        System.in.read();
    }

    public static void newThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            final int fi = i;
            threadPool.execute(() -> {
                System.out.println(fi);
            });
        }
        threadPool.shutdown();
        ExecutorService threadPool2 = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            final int fi = i;
            threadPool2.execute(() -> {
                System.out.println(fi);
            });
        }
        threadPool2.shutdown();
    }

}
