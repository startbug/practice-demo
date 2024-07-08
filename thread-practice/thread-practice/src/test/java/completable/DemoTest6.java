package completable;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 17:57
 */
public class DemoTest6 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
                    int i = 1 / 0;
                    System.out.println("aaa");
                    return "A";
                }).applyToEither(CompletableFuture.supplyAsync(() -> {
                    System.out.println("bbb");
                    return "B";
                }), firstCompeleteResult -> {
                    System.out.println(firstCompeleteResult);
                    return "C";
                }).exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return "GGG";
                })
                .whenComplete((result, ex) -> {
                    System.out.println(result);
                    System.out.println(ex);
                });
        System.out.println(task.get());
        System.in.read();
    }

}
