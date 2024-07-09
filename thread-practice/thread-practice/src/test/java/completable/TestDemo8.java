package completable;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/9 9:55
 */
public class TestDemo8 {

    public static void main(String[] args) throws IOException {
        CompletableFuture taskA = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("A");
        });
        taskA.thenRunAsync(() -> {
            System.out.println("B");
        });
        taskA.thenRunAsync(() -> {
            System.out.println("C");
        });
        taskA.thenRunAsync(() -> {
            System.out.println("D");
        });
        taskA.thenRunAsync(() -> {
            System.out.println("E");
        });

        System.in.read();
    }

}
