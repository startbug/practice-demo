package base1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/26 14:42
 */
public class TestDemo6 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println("t1获取锁资源----,time=" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1进入conditionObject等待，释放锁资源,time=" + System.currentTimeMillis());
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1等待结束，重新获取锁资源,time=" + System.currentTimeMillis());
            lock.unlock();
        }).start();

        TimeUnit.MILLISECONDS.sleep(500);
        lock.lock();
        System.out.println("main获取锁资源-----,time=" + System.currentTimeMillis());
        TimeUnit.MILLISECONDS.sleep(1000);
        condition.signal();
        lock.unlock();
    }

}
