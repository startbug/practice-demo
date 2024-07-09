package completable;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/9 9:12
 */
public class TestDemo7 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    System.out.println("任务A");
//                    int i = 1 / 0;
                    return 100;
                }).applyToEither(CompletableFuture.supplyAsync(() -> {
                    System.out.println("任务B");
                    return 55;
                }), firstResult -> {
                    System.out.println("任务C");
                    return firstResult;
                })
                // 发生异常时执行，会捕获异常
                .exceptionally(ex -> {
                    System.out.println("exceptionally发生异常!!!,ex=" + ex);
                    return -1;
                })
                // 是否发生异常都会执行，如果发生一场，会捕获异常
                .handle((result, ex) -> {
                    System.out.println("handle任务D,result=" + result);
                    System.out.println("handle任务D,ex=" + ex);
                    return -2;
                })
                // 是否发生异常都会执行，不会捕获异常，执行完whenComplete内部的代码后，结束
                .whenComplete((result, ex) -> {
                    System.out.println("whenComplete任务D,result=" + result);
                    System.out.println("whenComplete任务D,ex=" + ex);
                });
        System.out.println(future.join());
    }

}
