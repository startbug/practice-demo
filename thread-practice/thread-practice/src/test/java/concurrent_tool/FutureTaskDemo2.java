package concurrent_tool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/6 17:15
 */
public class FutureTaskDemo2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("任务执行中....");
            TimeUnit.SECONDS.sleep(2);
            return "okok";
        });

        threadPool.execute(futureTask);

        try {
            String s = futureTask.get(1, TimeUnit.SECONDS);
            System.out.println("任务结果:" + s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("任务执行失败:" + e.getMessage());
        }

    }

}
