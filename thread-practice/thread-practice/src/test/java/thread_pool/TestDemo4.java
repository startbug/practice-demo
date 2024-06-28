package thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 18:45
 */
public class TestDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new MyRejectedExecution());

        threadPool.submit(() -> {
            System.out.println("无返回结果");
        });

        Future<Object> future = threadPool.submit(() -> {
            System.out.println("有返回结果!!!");
            return "返回结果";
        });
        Object result = future.get();
        System.out.println(result);

        // 局部变量线程池，shutdown线程池
        threadPool.shutdown();
    }

    private static class MyRejectedExecution implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("自定义拒绝策略");
        }

    }

}
