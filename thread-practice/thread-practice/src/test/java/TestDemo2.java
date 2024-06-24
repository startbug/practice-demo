import java.util.concurrent.TimeUnit;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/6/24 17:22
 */
public class TestDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
        });
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }

//    public static void main(String[] args) throws InterruptedException {
//        // 线程默认情况下，interrupt标记位：false
//        System.out.println("1---" + Thread.currentThread().isInterrupted());    // false
//        // 执行interrupt之后，再次查看打断标记
//        Thread.currentThread().interrupt();
//        // interrupt标记为：true
//        System.out.println("2---" + Thread.currentThread().isInterrupted());    // true
//        System.out.println("3---" + Thread.currentThread().isInterrupted());    // true
//        // 返回当前线程的打断标记，并归为为false，interrupt标记位：true
//        System.out.println("4---" + Thread.interrupted());                      // true
//        // 已经归位
//        System.out.println("4---" + Thread.interrupted());                      // false
//
//        // =====================================
//        Thread t1 = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                // 处理业务
//            }
//            System.out.println("结束");
//        });
//        t1.start();
//        Thread.sleep(500);
//        t1.interrupt();
//    }

}
