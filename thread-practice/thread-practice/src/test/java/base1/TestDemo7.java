package base1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/27 14:52
 */
public class TestDemo7 {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("子线程!");
                TimeUnit.SECONDS.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                readLock.unlock();
            }
        }).start();


        TimeUnit.SECONDS.sleep(1);
        readLock.lock();
        try {
            System.out.println("主线程!");
        } finally {
            readLock.unlock();
        }

    }

}
