package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 17:46
 */
public class DemoTest5 {

    public static void main(String[] args) {
        // 默认使用ForkJoinPool作为线程池，为守护线程，不阻塞的话，主线程结束，子线程也随着结束
        System.out.println(System.currentTimeMillis());
        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("stage1:" + Thread.currentThread().getName() + "__" + System.currentTimeMillis());
            return 80;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println("stage2:" + Thread.currentThread().getName() + "__" + System.currentTimeMillis());
            return 40;
        }), (result1, result2) -> {
            System.out.println("begin_stage3:" + Thread.currentThread().getName() + "__" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
            System.out.println("end_stage3:" + Thread.currentThread().getName() + "__" + System.currentTimeMillis());
            return result1 + result2;
        });
        Integer result = task.join();
        System.out.println(result + "__" + System.currentTimeMillis());
    }

}
