package completable;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 17:03
 */
public class DemoTest4 {

    public static void main(String[] args) throws IOException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            return "abcdefg";
        }).thenAccept(result -> {
            System.out.println("任务B，拿到结果处理：" + result);
        });
        System.in.read();
    }

}
