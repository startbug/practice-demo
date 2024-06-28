package base1;

import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description 验证join方法是否会释放锁
 * join方法实际上是调用Object#wait方法，是会释放锁的，但是释放的是线程锁
 * 例如 Thread t3 = new Thread();
 * synchrnoized (t3) {}
 * 对t3作为锁对象，那么t3执行join方法后，会释放t3的锁资源
 * @Datetime 2024/6/27 14:12
 */
public class TestDemo3_1 {

    public static void main(String[] args) throws InterruptedException {

        long now = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1睡眠10s,time=" + (System.currentTimeMillis() - now));
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("进入t2,time=" + (System.currentTimeMillis() - now));
            synchronized (TestDemo3_1.class) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("t2执行join方法,time=" + (System.currentTimeMillis() - now));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("进入t3,time=" + (System.currentTimeMillis() - now));
            synchronized (t1) {
                try {
                    t1.join();
                    System.out.println("t3睡醒,time=" + (System.currentTimeMillis() - now));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        TimeUnit.MILLISECONDS.sleep(500);
        t2.start();
        t3.start();
        TimeUnit.MILLISECONDS.sleep(100);

        synchronized (t1) {
            System.out.println("main-obj---,time=" + (System.currentTimeMillis() - now));
        }

        System.out.println("main等待获取锁,time=" + (System.currentTimeMillis() - now));
        synchronized (TestDemo3_1.class) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("main打印啦,time=" + (System.currentTimeMillis() - now));
        }

    }

}
