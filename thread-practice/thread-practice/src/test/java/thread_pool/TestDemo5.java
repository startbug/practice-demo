package thread_pool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/7/2 14:59
 */
public class TestDemo5 {

    public static void main(String[] args) throws InterruptedException {
        // 交替输出ABC
        ReentrantLock lock = new ReentrantLock();
        Condition aCondition = lock.newCondition();
        Condition bCondition = lock.newCondition();
        Condition cCondition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    aCondition.await();
                    System.out.println("A");
                    bCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    bCondition.await();
                    System.out.println("B");
                    cCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    cCondition.await();
                    System.out.println("C");
                    aCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try {
            aCondition.signal();
        } finally {
            lock.unlock();
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//        Thread t1 = new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println("t1=========开始,time=" + System.currentTimeMillis());
//                condition.await();
//                System.out.println("t1=========结束,time=" + System.currentTimeMillis());
//            } catch (InterruptedException e) {
//                System.out.println("t1===发生中断一场");
//            } finally {
//                lock.unlock();
//            }
//        });
//        t1.start();
//
//        TimeUnit.MILLISECONDS.sleep(500);
//        lock.lock();
//        try {
//            System.out.println("main=======开始,time=" + System.currentTimeMillis());
//            TimeUnit.SECONDS.sleep(5);
//            t1.interrupt();
//            condition.await(1, TimeUnit.SECONDS);
//            System.out.println("main=======结束,time=" + System.currentTimeMillis());
//        } finally {
//            lock.unlock();
//        }
//    }


// t1=========开始,time=1719904261169
// main=======开始,time=1719904261684
// t1===发生中断一场
// main=======结束,time=1719904267695
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            try {
//                synchronized (TestDemo5.class) {
//                    System.out.println("t1=========开始,time=" + System.currentTimeMillis());
//                    TestDemo5.class.wait();
//                    System.out.println("t1=========结束,time=" + System.currentTimeMillis());
//                }
//            } catch (InterruptedException e) {
//                System.out.println("t1===发生中断一场");
//            }
//        });
//        t1.start();
//
//        TimeUnit.MILLISECONDS.sleep(500);
//        synchronized (TestDemo5.class) {
//            System.out.println("main=======开始,time=" + System.currentTimeMillis());
//            TimeUnit.SECONDS.sleep(5);
//            t1.interrupt();
//            TestDemo5.class.wait(1000);
//            System.out.println("main=======结束,time=" + System.currentTimeMillis());
//        }
//    }

}
