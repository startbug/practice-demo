package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 16:00
 */
public class DemoTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 不指定线程池的时候，默认创建ForkJoinPool，是守护线程，子线程还没有跑完，可能主线程就结束了，导致子线程也强制结束
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务开始执行");
            System.out.println("异步任务执行结束");
            return "结果";
        });
        // 异常内部处理了
//        String s = firstTask.join();
        // 异常可以抛出到调用线程
        String s = firstTask.get();
        System.out.println(s);
    }

}
