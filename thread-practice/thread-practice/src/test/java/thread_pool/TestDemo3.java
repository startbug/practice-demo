package thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/28 17:53
 */
public class TestDemo3 {

    static int[] nums = new int[1_000_000_000];

    // 填充值
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 1000);
        }
    }

    public static void main(String[] args) {
        // -----------------------单线程累加10亿数据--------------------------
        System.out.println("单线程计算数组总和！");
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long end = System.nanoTime();
        System.out.println("单线程结果:" + sum + ",耗时:" + (end - start) + "ns");

        // -----------------------多线程分而治之累加10亿数据--------------------------
        // 在使用FortJoinPool时，不推荐使用Runnable和Callable
        // 可以使用提供的另外两种任务的描述方式
        // Runnable(没有返回结果)  -> RecursiveAction
        // Callable(有返回结果)    -> RecursiveTask
        ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        long fortJoinStart = System.nanoTime();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new SumRecursiveTask(0, nums.length - 1));
        Integer fortSum = forkJoinTask.join();
        long fortJoinEnd = System.nanoTime();
        System.out.println("多线程结果:" + fortSum + ",耗时:" + (fortJoinEnd - fortJoinStart) + "ns");
    }


    private static class SumRecursiveTask extends RecursiveTask<Integer> {

        /** 指定一个线程处理那个位置的数据 */
        private int start, end;
        private int MAX_STRIDE = 200_000_000;

        public SumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * 拆分8个线程，每个线程处理1.25亿个数字累加任务
         * @return
         */
        @Override
        protected Integer compute() {
            int stride = end - start;
            int sum = 0;
            if (stride <= MAX_STRIDE) {
                // 处理任务
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
            } else {
                // 分而治之
                int middle = (start + end) / 2;
                // 拆分成两个任务
                SumRecursiveTask leftTask = new SumRecursiveTask(start, middle);
                SumRecursiveTask rightTask = new SumRecursiveTask(middle + 1, end);
                // 分别执行两个任务
                leftTask.fork();
                rightTask.fork();
                // 等待结果，并且获取sum
                sum = leftTask.join() + rightTask.join();
            }
            return sum;
        }

    }
}
