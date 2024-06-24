import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/24 15:38
 */
public class TestDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sync();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                sync();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2");
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(12);
        synchronized (TestDemo1.class) {
            TestDemo1.class.notifyAll();
        }
    }

    public static synchronized void sync() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                TestDemo1.class.wait();
            }
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        }
    }


    @Test
    public void test2() throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println("t1-thread");
            }
        });
        synchronized (obj) {
            t1.start();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(t1.getState());
        }
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        // do something...
        Integer count = futureTask.get();
        System.out.println("count====" + count);
    }

    class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                count += i;
            }
            return count;
        }

    }

}
