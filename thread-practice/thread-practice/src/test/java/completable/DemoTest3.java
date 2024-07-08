package completable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 16:20
 */
public class DemoTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s1 = CompletableFuture
                .supplyAsync(() -> UUID.randomUUID().toString())
                .thenApply(preResult -> {
//                    System.out.println(1 / 0);
                    return preResult.replaceAll("-", "");
                }).join();
        System.out.println(s1);

        String s2 = CompletableFuture
                .supplyAsync(() -> UUID.randomUUID().toString())
                .thenApply(preResult -> {
//                    System.out.println(1 / 0);
                    return preResult.replaceAll("-", "");
                }).get();
        System.out.println(s2);
    }

}
