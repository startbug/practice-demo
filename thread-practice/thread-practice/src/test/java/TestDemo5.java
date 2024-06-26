import java.util.concurrent.TimeUnit;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/25 16:31
 */
public class TestDemo5 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        new Thread(() -> {
            // t1 - 偏向锁
            synchronized (o) {
                System.out.println("t1" + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

        // main - 偏向锁 - 轻量级锁CAS - 重量级锁
        synchronized (o) {
            System.out.println("main" + ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
