package completable;

import java.util.concurrent.CompletableFuture;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/8 16:11
 */
public class DemoTest2 {

    public static void main(String[] args) {
        CompletableFuture.runAsync(()->{
            System.out.println("asaaa");
        });
    }

}
